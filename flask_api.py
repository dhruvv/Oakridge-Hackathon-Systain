from flask import Flask, jsonify, request

app = Flask(__name__)
data = {"turbidity":0, "lat":0, "long":0, "temperature":0}

@app.route('/put')
def put():
    data['turbidity'] = request.form['turbidity']
    data['lat'] = request.form['lat']
    data['long'] = request.form['long']
    data['temperature'] = request.form['temperature']
    return jsonify(data)
@app.route('/')
def get():
    return jsonify(data)
