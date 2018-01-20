from flask import Flask, jsonify, request

app = Flask(__name__)
data = {"data":0}

@app.route('/put')
def put():
    data['data'] = request.form['data']
@app.route('/')
def get():
    return jsonify(data)

    
