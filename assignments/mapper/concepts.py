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
        self.student_map = {}
        

    def map_to_object(self, student_table_row):
        student = Student(student_table_row[1], student_table_row[2])
        return student



def sql_result_from_database():
    conn = sqlite3.connect('university.sqlite3')
    cursor = conn.cursor()
    return cursor.fetchall()



if __name__ == "__main__":

    results = sql_result_from_database()
    student_result = results[0]
    studetnMapper = StudentMapper()
    student = StudentMapper.map_to_object(student_result)

    pprint(student) # output is mapped result from database

    print("Student - name: %s, dept: %s" % (student.name, student.dept.name))
