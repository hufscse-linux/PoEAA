import unittest
import concepts
import sqlite3
from concepts import *

class StudentMapperTest(unittest.TestCase):    
    
    def setUp(self):
        self.studentMapper = StudentMapper()
        self.conn = sqlite3.connect('university.sqlite3') 
        self.cursor = self.conn.cursor()
        self.cursor.execute('select * from students')
        self.student_table_data = self.cursor.fetchall()

    def test_sql_result_from_database(self):
        results = concepts.sql_result_from_database()
        self.assertIsInstance(results, list)
        for student in results:
            self.assertIn(student, self.student_table_data)

    def test_StudentMapper_map_to_object(self):
        student_row = self.student_table_data[0]
        student = self.studentMapper.map_to_object(student_row)
        self.assertIsInstance(student, Student)
        self.assertEqual(student.name, student_row[1])
        self.assertIsInstance(student.dept, Department)
        self.assertEqual(student.dept.name, student_row[2])

    def test_StudentMapper_find_student_object(self):
        self._insert_student_object_to_student_map_in_StudentMapper()
        student_row = self.student_table_data[0]
        student = self.studentMapper.find_object(student_row)
        self.assertIsInstance(student, Student)
        self.assertEqual(student.name, student_row[1])
        self.assertIsInstance(student.dept, Department)
        
    def _insert_student_object_to_student_map_in_StudentMapper(self):
        student_row = self.student_table_data[0]
        student = self.studentMapper.map_to_object(student_row)
        self.studentMapper.object_map[student_row[0]] = student
        

