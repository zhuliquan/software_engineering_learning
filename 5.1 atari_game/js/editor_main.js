var main = function () {
    var canvas = document.getElementById('id_canvas')
    var context = canvas.getContext("2d")
    var buttonRed = document.getElementById('id_button_red')
    var buttonGreen = document.getElementById('id_button_green')
    var buttonBlue = document.getElementById('id_button_blue')
    var colorSelect = document.getElementById('id_color_select')
    var bullet = new GameBullet("../img/bullet.JPG")
    var paddle = new GamePaddle("../img/paddle.JPG")
    speedSwitch = document.getElementById("id_range")
    //改变速度监听
    speedSwitch.addEventListener('input', function (event) {
        var localFps = (Number(speedSwitch.value) + 10) * 0.6
        log(localFps)
    })
    bullet.x = 10; bullet.y = 10
    paddle.x = 50; paddle.y = 50
    bullet.image.onload = function () {
        context.drawImage(bullet.image, bullet.x, bullet.y)
    }
    paddle.image.onload = function () {
        context.drawImage(paddle.image, paddle.x, paddle.y)
    }
    var objects = []
    objects.push(paddle)
    objects.push(bullet)
    var dragBlock = null
    buttonRed.addEventListener('click', function () {
        var redBlock = new GameBlock('../img/block1.JPG')
        var image = redBlock.image
        image.onload = function () {
            context.drawImage(image, redBlock.x, redBlock.y)
        }
        objects.push(redBlock)
    })
    buttonGreen.addEventListener('click', function () {
        var greenBlock = new GameBlock('../img/block2.JPG')
        var image = greenBlock.image
        image.onload = function () {
            context.drawImage(image, greenBlock.x, greenBlock.y)
        }
        objects.push(greenBlock)
    })
    buttonBlue.addEventListener('click', function () {
        var blueBlock = new GameBlock('../img/block3.JPG')
        var image = blueBlock.image
        image.onload = function () {
            context.drawImage(image, blueBlock.x, blueBlock.y)
        }
        objects.push(blueBlock)
    })
    colorSelect.onchange = function () {
        context.fillStyle = colorSelect.value
    }
    canvas.addEventListener('mousedown', function (event) {

        for (var i = 0; i < objects.length; i++) {
            var b = objects[i]
            if (b.hasPoint(event.offsetX, event.offsetY)) {
                b.enableDrag = true
                dragBlock = b
                break
            }
        }

    })
    canvas.addEventListener('mousemove', function () {
        if (dragBlock && dragBlock.enableDrag) {
            dragBlock.x = event.offsetX
            dragBlock.y = event.offsetY
        }
    })
    canvas.addEventListener('mouseup', function () {
        if (dragBlock) {
            dragBlock.enableDrag = false
        }
    })

    setInterval(function () {
        context.clearRect(0, 0, 400, 300)
        context.fillRect(0, 0, canvas.width, canvas.height)
        for (var i = 0; i < objects.length; i++) {
            var b = objects[i]
            context.drawImage(b.image, b.x, b.y)
        }
    }, 25)
}