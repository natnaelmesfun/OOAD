from flask import Flask, render_template, url_for, request, session, redirect, jsonify
from flask_login import logout_user
from flask_pymongo import PyMongo
import bcrypt
from planner_controller import User
from planner_model import UserModel

app = Flask(__name__)

app.config['MONGO_DBNAME'] = 'PlannerDB'
app.config['MONGO_URI'] = 'mongodb://localhost:27017/PlannerDB'

mongo = PyMongo(app)


@app.route('/')
def index():

    if 'username' in session:
        username = session['username']
        return render_template('home.html')
    return render_template('index.html')

@app.route('/home')
def home():
    return render_template('home.html')


@app.route('/login', methods=['POST'])
def login():
    session['username'] = request.form['username']  #.strip()
    users = mongo.db.users
    login_user = users.find_one({'name' : request.form['username']})
    # login_user = UserModel.find_user(users, request.form['username'])


    if login_user:
        # hashpass = User.hash_pass(request.form['pass'].encode('utf-8'))
        hashpass = bcrypt.hashpw(request.form['pass'].encode('utf-8'), bcrypt.gensalt())
        # User.validate_login(hashpass, request.form['pass'])
        if bcrypt.hashpw(bytes(request.form['pass'], 'utf-8'), hashpass) == hashpass:
            session['username'] = request.form['username']
            return redirect(url_for('index'))

    return 'Invalid username/password combination'




@app.route('/register', methods=['POST', 'GET'])
def register():
    if request.method == 'POST':
        users = mongo.db.users
        #existing_user = users.find_one({'name' : request.form['username']})
        existing_user = UserModel.find_user(users, request.form['username'])

        if existing_user is None:
            hashpass = User.hash_pass(request.form['pass'].encode('utf-8'))
            UserModel.insert_database(users, request.form['username'], hashpass)
            # users.insert({'name' : request.form['username'], 'password' : hashpass})
            session['username'] = request.form['username']
            return render_template('index.html') #redirect(url_for('index'))
        
        return 'That username already exists!'

    return render_template('register.html')


@app.route('/personalPlannerIndex')
def personalPlannerIndex():
    return render_template('personalPlannerIndex.html')


# Add Event to database
@app.route('/planner_main', methods=['POST'])
def planner_main():

    if request.method == 'POST':
        user_name = session.get('username')
        users = mongo.db.users
        user_mongo = users.find_one({'name' : user_name})
        collection_id = user_mongo.get('_id')
        data = request.json

        #Retriving data
        motivations = data['motivation_list']
        todo = data['todo_list']
        goals = data['goals_list']
        schedule = data['schedule_list']

        #Inserting data into database

        if motivations:
            UserModel.insert_motivations(users, collection_id, motivations)
            # users.update({"_id": collection_id}, {"$set" : {'motivations' : motivations}})

        if todo:
            UserModel.insert_todo(users, collection_id, todo)

        if goals:
            UserModel.insert_goals(users, collection_id, goals)

        if schedule:
            UserModel.insert_schedule(users, collection_id, schedule)

        return render_template('displayPage.html')



@app.route('/displayPage')
def displayPage():

    user_name = session.get('username')
    users = mongo.db.users
    user_mongo = users.find_one({'name' : user_name})

    motivations = user_mongo.get('motivations')
    todo = user_mongo.get('todo')
    goals = user_mongo.get('goals')
    schedule = user_mongo.get('schedule')

    return render_template('displayPage.html', motivations=motivations, todo=todo, goals=goals, schedule=schedule)



@app.route("/logout")
def logout():
    session.pop('username')
    return redirect('/')
	
		

if __name__ == '__main__':
    app.secret_key = 'mysecret'
    app.run(debug=True)

