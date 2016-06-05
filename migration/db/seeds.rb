require 'namey'
require 'haikunator'

generator = Namey::Generator.new

class Student < ActiveRecord::Base
  belongs_to :department
  has_many :course_registrations
  has_many :courses, through: :course_registrations
end

class Department < ActiveRecord::Base
  has_many :courses
  has_many :students
  has_many :professors
end

class Professor < ActiveRecord::Base
  belongs_to :department
  has_many :courses
end

class Course < ActiveRecord::Base
  belongs_to :department
  belongs_to :professor
  has_many :course_registrations
  has_many :students, through: :course_registrations
end

class CourseRegistration < ActiveRecord::Base
  belongs_to :student
  belongs_to :course
end

ActiveRecord::Base.transaction do
  10.times { Department.create(name: Haikunator.haikunate(0, ' ')) }

  departments = Department.all

  30.times do |i|
    Professor.create(
      name: generator.name,
      department: departments[i % 10]
    )
  end

  professors = Professor.all

  1000.times do |i|
    Course.create(
      name: Haikunator.haikunate(0, ' '),
      professor: professors[i % 30],
      department: departments[i % 10]
    )
  end

  courses = Course.all

  300.times do |i|
    registrations = []
    n_courses = rand(4..8)
    n_courses.times do
      registrations << courses[rand(0..299)]
    end

    Student.create(
      name: generator.name(:all),
      department: departments[i % 10],
      courses: registrations
    )
  end
end
