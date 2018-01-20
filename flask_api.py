from flask import Flask, jsonify, request

app = Flask(__name__)
data = {"turbidity":"0", "lat":0, "long":0, "temperature":0}

@app.route('/put', methods=["PUT"])
def put():
    global data
    data = request.get_json(force=True)
    return jsonify(data)
@app.route('/')
def get():
    return jsonify(data)

@app.route('/post', methods=["POST"])
def post():
    global data
    data['turbidity'] = request.get_json(force=True)
    return jsonify(data)
