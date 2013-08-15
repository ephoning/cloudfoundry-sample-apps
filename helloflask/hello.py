import os
from flask import Flask

app = Flask(__name__)

@app.route('/')
def hello():
    env = str(os.environ)
    return '<h2>Hello World!</h2>' + env

 
