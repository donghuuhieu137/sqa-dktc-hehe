<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/login.css">
    <title>Document</title>
</head>

<body>

<div class="container">
    <form id="form-login" action="" method="post">

        <div class="signup">
            <div class="signup__head">
                <div>
                    <h3 class="signup__title" >
                        ĐĂNG NHẬP
                    </h3>
                </div>
            </div>

            <div class="signup__body">

                <div class="form-group">
                        <input type="text" class="signup__input" name="username" placeholder="Tên đăng nhập">
                </div>

                <div class="form-group">
                        <input type="password" class="signup__input" name="password" placeholder="Mật khẩu">

                </div>

            </div>
        </div>

        <font color="red">${errorMessage}</font>

        <div style="display: flex; justify-content: center;">
            <input type="submit" value="Đăng nhập" class="form-submit">
        </div>

    </form>

</div>
</body>

</html>
