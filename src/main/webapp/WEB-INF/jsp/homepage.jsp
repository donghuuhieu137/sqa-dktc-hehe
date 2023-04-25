<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/homepage.css">
    <title>Document</title>
</head>

<body>

<div class="container">
    <div class="border">
        <div style="display: flex; justify-content: center;">
            <a class="btn" href="/subject-register">
               Đăng ký tín chỉ
            </a>
        </div>
        <div style="display: flex; justify-content: center;">
            <a class="btn" href="/list-subject">
               Xem môn học đã đăng kí
            </a>
        </div>
    </div>

    <font color="red">${errorMessage}</font>
</div>
</body>

</html>
