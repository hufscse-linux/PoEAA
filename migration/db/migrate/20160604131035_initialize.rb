class Initialize < ActiveRecord::Migration
  def change
    create_table :students do |t|
      t.string :name
    end

    create_table :departments do |t|
      t.string :name
    end
    
    create_table :courses do |t|
      t.string :name
    end
    
    create_table :professors do |t|
      t.string :name
    end

    create_table :course_registrations

    add_reference :professors, :department, index: true, foreign_key: true
    
    add_reference :students, :department, index: true, foreign_key: true
    
    add_reference :courses, :department, index: true, foreign_key: true
    add_reference :courses, :professor, index: true, foreign_key: true

    add_reference :course_registrations, :student, index: true, foreign_key: true
    add_reference :course_registrations, :course, index: true, foreign_key: true
  end
end
