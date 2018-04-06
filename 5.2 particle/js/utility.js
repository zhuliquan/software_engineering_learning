function randomInt(min, max) {
    return ~~(Math.random() * (max - min) + min);
}
function randomDouble(min, max) {
    return (Math.random() * (max - min) + min);
}
function degree2Rad(degree) {
    return degree / 180 * Math.PI;
}