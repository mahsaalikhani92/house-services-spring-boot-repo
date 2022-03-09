const imageFile = document.getElementById("personalImage");

imageFile.onchange = function () {
    const allowedType = ["jpg", "jpeg"];
    const extension = this.value.split(".").pop().toLowerCase();
    if(!allowedType.includes(extension)){
        alert("Personal image type not supported! Choose jpg or jpeg file.")
        this.value = "";
    }
}