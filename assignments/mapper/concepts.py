#!/usr/bin/env python2

from pprint import pprint
import sqlite3

class Department(object):
    def __init__(self, name):
        self.name = name

class Student(object):

    def __init__(self, name, dept):
        self.name = name
        self.dept = dept

class StudentMapper(object):

    def __init__(self):
        self.object_map = {}
        self.conn = sqlite3.connect('university.sqlite3')
        self.cursor = self.conn.cursor()

    def map_to_object(self, student_table_row):
        department = Department(student_table_row[2])
        student = Student(student_table_row[1], department)
        return student

    def find_object(self, student_row):
        if self.object_map[student_row[0]] is not None:
            return self.object_map[student_row[0]]
        else:
            return self.map_to_object(student_row) 


def sql_result_from_database():
    conn = sqlite3.connect('university.sqlite3')
    cursor = conn.cursor()
    cursor.execute('select * from students')
    return cursor.fetchall()


if __name__ == "__main__":

    results = sql_result_from_database()
    student_result = results[0]
    studentMapper = StudentMapper()
    student = studentMapper.map_to_object(student_result)

    pprint(student) # output is mapped result from database

    print("Student - name: %s, dept: %s" % (student.name, student.dept.name))
