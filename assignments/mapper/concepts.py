#!/usr/bin/env python2

from pprint import pprint

class Student(object):

    def __init__(self, name, dept):
        self.name = name
        self.dept = dept

class StudentMapper(object):

    def map_to_object(self):
        pass

def sql_result_from_database():
    pass

result = sql_result_from_database()
student = StudentMapper.map_to_object(result)

pprint(student) # output is mapped result from database
