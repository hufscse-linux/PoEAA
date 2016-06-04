# encoding: UTF-8
# This file is auto-generated from the current state of the database. Instead
# of editing this file, please use the migrations feature of Active Record to
# incrementally modify your database, and then regenerate this schema definition.
#
# Note that this schema.rb definition is the authoritative source for your
# database schema. If you need to create the application database on another
# system, you should be using db:schema:load, not running all the migrations
# from scratch. The latter is a flawed and unsustainable approach (the more migrations
# you'll amass, the slower it'll run and the greater likelihood for issues).
#
# It's strongly recommended that you check this file into your version control system.

ActiveRecord::Schema.define(version: 20160604131035) do

  create_table "course_registrations", force: :cascade do |t|
    t.integer "student_id"
    t.integer "course_id"
  end

  add_index "course_registrations", ["course_id"], name: "index_course_registrations_on_course_id"
  add_index "course_registrations", ["student_id"], name: "index_course_registrations_on_student_id"

  create_table "courses", force: :cascade do |t|
    t.string  "name"
    t.integer "department_id"
    t.integer "professor_id"
  end

  add_index "courses", ["department_id"], name: "index_courses_on_department_id"
  add_index "courses", ["professor_id"], name: "index_courses_on_professor_id"

  create_table "departments", force: :cascade do |t|
    t.string "name"
  end

  create_table "professors", force: :cascade do |t|
    t.string  "name"
    t.integer "department_id"
  end

  add_index "professors", ["department_id"], name: "index_professors_on_department_id"

  create_table "students", force: :cascade do |t|
    t.string  "name"
    t.integer "department_id"
  end

  add_index "students", ["department_id"], name: "index_students_on_department_id"

end
