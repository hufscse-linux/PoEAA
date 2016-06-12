import unittest
import sk_mapper
import sqlite3
from sk_mapper import *

class StudentMapperTest(unittest.TestCase):    
    
    def setUp(self):
        self.studentMapper = StudentMapper()
        self.conn = sqlite3.connect('university.sqlite3')
        self.conn.row_factory = sqlite3.Row
        self.cursor = self.conn.cursor()
        self.cursor.execute('select s.name s_name, d.name d_name from students s inner join departments d on s.department_id=d.id')
        self.student_table_data = self.cursor.fetchall()

    def test_StudentMapper_map_to_object(self):
        for row in self.student_table_data:
            student = self.studentMapper.map_to_object(row)
            print student
            self.assertIsInstance(student, Student)
            self.assertIsInstance(student.name, unicode)
            self.assertIsInstance(student.dept, unicode)
            #self.assertIsInstance(student.dept, Department)
            #self.assertIsInstance(student.dept.name, unicode)

