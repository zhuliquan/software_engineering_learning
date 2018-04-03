function Particle(opt) {
    this.init(opt);
}
Particle.prototype = {
    init: function (opt) {
        this.x = opt.x;//圆心 x
        this.y = opt.y;//圆心 y
        this.radius = opt.radius;//半径
        this.color = opt.color;//颜色
        this.speed_x = opt.speed * Math.cos(opt.theta); //速度 x
        this.speed_y = opt.speed * Math.sin(opt.theta); //速度 y
    },
    draw: function (ctx) {
        ctx.beginPath();
        ctx.arc(this.x, this.y, this.radius, 0, 2 * Math.PI);
        ctx.fillStyle = this.color;
        ctx.fill();
    },
    update: function () {
        this.x += this.speed_x;
        this.y += this.speed_y;
    }
}
function born_particles(cx, cy) {
    var color_kind = COLORS.length;
    generate_number = randomInt(0, 20);
    for (var i = 1; i <= generate_number; i++) {
        particles.push(new Particle({
            x: cx, y: cy,
            radius: randomInt(MIN_RIDUS, MAX_RIDUS),
            color: COLORS[randomInt(0, color_kind)],
            theta: degree2Rad(randomInt(0, 360)),
            speed: randomInt(MIN_SPEED, MAX_SPEED),
        }));
        if (particles.length >= MAX_NUM) {
            particles.shift();
        }
    }
}
