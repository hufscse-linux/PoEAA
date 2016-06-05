#!/usr/bin/env python2

from pprint import pprint

class Department(object):
    def __init__(self, name):
        self.name = name

class Student(object):

    def __init__(self, name, dept):
        self.name = name
        self.dept = dept

class StudentMapper(object):

    def map_to_object(self):
        pass

def sql_result_from_database():
    # read university.sqlite3 and select student information
    pass

result = sql_result_from_database()
student = StudentMapper.map_to_object(result)

pprint(student) # output is mapped result from database

print("Student - name: %s, dept: %s" % (student.name, student.dept.name))
