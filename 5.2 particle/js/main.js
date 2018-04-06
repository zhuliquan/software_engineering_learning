
function main() {
    var canvas = document.querySelector("canvas");
    var ctx = canvas.getContext("2d");
    canvas.width = window.innerWidth;
    canvas.height = window.innerHeight;
    function render() {
        var particles_number = particles.length;
        ctx.clearRect(0, 0, canvas.width, canvas.height);
        for (var i = 0; i < particles_number; i++) {
            particles[i].draw(ctx);
        }
        for (var i = 0; i < particles_number; i++) {
            particles[i].update();
        }
        setTimeout(render, 1000 / fps);
    }
    setTimeout(render, 1000 / fps);
    // requestAnimationFrame(render);//绘制整个界面
    canvas.onmousemove = function (e) {
        born_particles(e.pageX, e.pageY);//在该点下生成粒子

    }
    // canvas.onmousedown = function (e) {
    // }
}