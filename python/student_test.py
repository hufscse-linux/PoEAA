#!/usr/bin/env python2

from behave import *

from sqlalchemy import create_engine
from sqlalchemy import Column, Integer, String, ForeignKey
from sqlalchemy.orm import sessionmaker, relationship
from sqlalchemy.ext.declarative import declarative_base

engine = create_engine('sqlite:///university.sqlite3', echo=True)
Base = declarative_base()

class Department(Base):
    __tablename__ = 'departments'
    id = Column(Integer, primary_key=True)
    name = Column(String)
    students = relationship("Student", back_populates="department")

    def __repr__(self):
        return "<Department(name='%s')>" % (self.name)

class Student(Base):
    __tablename__ = 'students'
    id = Column(Integer, primary_key=True)
    name = Column(String)
    department_id = Column(Integer, ForeignKey('departments.id'))
    department = relationship("Department", back_populates="students")

    def __repr__(self):
        return "<User(name='%s', department='%s')" % (self.name, self.department)

Session = sessionmaker(bind=engine)
session = Session()

def test_student_should_have_department():
    for student in session.query(Student).join(Student.department):
        assert student.name is not None
        assert student.department is not None
        assert student.department.name is not None
