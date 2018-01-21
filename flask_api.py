from flask import Flask, jsonify, request

app = Flask(__name__)
data = {"turbidity":0}

@app.route('/')
def get():
    return jsonify(data)

@app.route('/post', methods=["POST"])
def post():
    global data
    turbidityValue = request.get_json(force=True)
    turbidityNTU = (-1120.4*(turbidityValue**2))+((5742.3)*(turbidityValue))-(4352.9)
    data['turbidity'] = turbidityNTU
    return jsonify(data)
