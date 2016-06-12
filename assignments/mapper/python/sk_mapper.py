#!/usr/bin/env python2

from pprint import pprint
import sqlite3

class Department(object):
    def __init__(self, name):
        self.name = name

class Student(object):
    column_name = 's_name'
    column_dept_name = 'd_name'
    
    def __init__(self, **kwargs):
        for k in kwargs:
            setattr(self, k, kwargs[k])

    def __repr__(self):
        return "<Student name: %s, dept: %s>" % (self.name, self.dept)

class StudentMapper(object):

    def __init__(self):
        self.object_map = {}

    def map_to_object(self, row):
        column_name = Student.__dict__['column_name']
        column_dept_name = Student.__dict__['column_dept_name']
        student = Student(name=row[column_name], dept=row[column_dept_name])
        return student

    def find_object(self, student_row):
        if self.object_map[student_row[0]] is not None:
            return self.object_map[student_row[0]]
        else:
            return self.map_to_object(student_row) 


def sql_result_from_database():
    conn = sqlite3.connect('university.sqlite3')
    cursor = conn.cursor()
    cursor.execute('select id, name, department_id from students')
    return cursor.fetchall()


if __name__ == "__main__":

    results = sql_result_from_database()
    student_result = results[0]
    studentMapper = StudentMapper()
    student = studentMapper.map_to_object(student_result)

    pprint(student) # output is mapped result from database

    print("Student - name: %s, dept: %s" % (student.name, student.dept.name))
