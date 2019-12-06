from flask import Flask, render_template, url_for, request, session, redirect
from flask_login import logout_user
from flask_pymongo import PyMongo
import bcrypt

app = Flask(__name__)

app.config['MONGO_DBNAME'] = 'PlannerDB'
app.config['MONGO_URI'] = 'mongodb://localhost:27017/PlannerDB'

mongo = PyMongo(app)


# @app.route('/', methods=['GET', 'POST'])
@app.route('/')
def index():

    if 'username' in session:
        return render_template('home.html')#return render_template('personalPlannerIndex.html')

    return render_template('index.html')

@app.route('/login', methods=['POST'])
def login():
    users = mongo.db.users
    login_user = users.find_one({'name' : request.form['username']})

    if login_user:
        hashpass = bcrypt.hashpw(request.form['pass'].encode('utf-8'), bcrypt.gensalt())
        if bcrypt.hashpw(bytes(request.form['pass'], 'utf-8'), hashpass) == hashpass:
            session['username'] = request.form['username']
            return redirect(url_for('index'))

    return 'Invalid username/password combination'

@app.route('/register', methods=['POST', 'GET'])
def register():
    if request.method == 'POST':
        users = mongo.db.users
        existing_user = users.find_one({'name' : request.form['username']})

        if existing_user is None:
            hashpass = bcrypt.hashpw(request.form['pass'].encode('utf-8'), bcrypt.gensalt())
            users.insert({'name' : request.form['username'], 'password' : hashpass})
            session['username'] = request.form['username']
            return render_template('index.html') #redirect(url_for('index'))
        
        return 'That username already exists!'

    return render_template('register.html')


@app.route('/home')
def home():
    return render_template('home.html')

@app.route('/personalPlannerIndex')
def personalPlannerIndex():
    return render_template('personalPlannerIndex.html')



# Add Event to database
@app.route('/Planneddata', methods=['GET', 'POST'])
def Planneddata():
    # if request.method == "POST":
    #       data=request.get_json()

    # motivation = data["motivation_list"]
    # print(motivation)
    data=request.get_json()
    x = data['x']

    return x

    #return render_template('Planneddata.html', data=data)

@app.route("/logout")
def logout():
    session.pop('username')
    return redirect('/')


if __name__ == '__main__':
    app.secret_key = 'mysecret'
    app.run(debug=True)