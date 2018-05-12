let canvas = document.getElementById("rain");
let context = canvas.getContext('2d');
var w, h;
function setSize() {
    w = window.innerWidth;
    h = window.innerHeight;
    canvas.width = w;
    canvas.height = h;
}
window.onresize = setSize;
setSize();
random = function (min, max) {
    return Math.random() * (max - min) + min;
}
function Rain() { }
Rain.prototype = {
    init: function () {
        this.x = random(0, w);
        this.y = 0;
        this.v_y = random(3, 5);
        this.r = 1;
        this.v_r = random(2, 4);
    },
    draw: function () {
        context.beginPath();
        if (this.y <= 0.89 * h) {
            context.fillStyle = "white";
            context.fillRect(this.x, this.y, 4, 10);
        } else {
            context.strokeStyle = "white";
            context.strokeArc(this.x, this.y, this.r, 0, 2 * Math.PI);
        }
    },
    move: function () {
        if (this.y <= 0.89 * h) {
            this.y += this.v_y;
        } else {
            this.r += this.v_r;
            if (this.r >= 50) {
                this.init();
            }
        }
    }
}
rains = []
createRain = function (num) {
    for (let i = 0; i < num; i++) {
        setTimeout(
            function () {
                rain = new Rain();
                rain.init();
                rain.draw();
                rains.push(rain);
            },
            200 * i
        );
    }
}
createRain(50);
run = function () {
    context.fillStyle = "rgba(0,0,0,0.05)";
    context.fillRect(0, 0, w, h);
    for (let rain of rains) {
        rain.move();
        rain.draw();
    }
}
setInterval(run, 1000 / 30);