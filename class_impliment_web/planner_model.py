from flask import Flask, render_template, url_for, request, session, redirect
from flask_login import logout_user
from flask_pymongo import PyMongo
import bcrypt

class UserModel:

	def find_user(users, username):
		return users.find_one({'name' : username})

	def insert_database(users, username, hashpass):
		users.insert({'name' : username, 'password' : hashpass})

	def insert_schedule(users, schedule):
		users.insert({'schedule' : schedule})

	def insert_goals(users, goals):
		users.insert({'goals' : goals})

	def insert_todo(users, todo):
		users.insert({'todo' : todo})


	def insert_motivations(users, motivations):
		users.insert({'motivations' : motivations})



