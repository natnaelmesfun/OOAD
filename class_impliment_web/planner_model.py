from flask import Flask, render_template, url_for, request, session, redirect
from flask_login import logout_user
from flask_pymongo import PyMongo
import bcrypt

class UserModel:

	def find_user(users, username):
		return users.find_one({'name' : username})

	def insert_database(users, username, hashpass):
		users.insert({'name' : username, 'password' : hashpass})

	def insert_schedule(users, id, schedule):
		users.update({"_id": id}, {"$set" : {'schedule' : schedule}})

	def insert_goals(users, id, goals):
		users.update({"_id": id}, {"$set" : {'goals' : goals}})

	def insert_todo(users, id,todo):
		users.update({"_id": id}, {"$set" : {'todo' : todo}})

	def insert_motivations(users, id, motivations):
		users.update({"_id": id}, {"$set" : {'motivations' : motivations}})


	def get_motivations(dictionary):
		return dictionary.get('motivations')

	def get_todo(dictionary):
		return dictionary.get('todo')

	def get_goals(dictionary):
		return dictionary.get('goals')

	def get_schedule(dictionary):
		return dictionary.get('schedule')



