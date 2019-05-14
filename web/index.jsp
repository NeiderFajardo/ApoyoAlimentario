<%-- Created by IntelliJ IDEA. --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

  <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css"
        integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf"
        crossorigin="anonymous">
  <link rel="stylesheet" type="text/css" href="estilos/styles.css"/>
  <link href="https://fonts.googleapis.com/css?family=Heebo" rel="stylesheet">
  <title>Apoyo Alimentario</title>
</head>

<body>
<header class="titulo">
  <h1>Programa Apoyo Alimentario</h1>
  <img src="imgs/logoud_0.png" alt="logoUd" width="100" height="100">
  <h2>Ingreso</h2>
</header>
<div class="formulario">
  <form method="post" action="loginServlet">
    <!-- <div class="field-name">
      <i class="far fa-user"></i>
      <input id="nombreUsuario" type="text" placeholder="Nombre de Usuario" required name="nombre">
    </div> -->

    <div class="field-email">
      <i class="far fa-envelope-open"></i>
      <input id="correoUsuario" type="email" placeholder="Correo" required name="correo">
    </div>
    <div class="field-password">
      <i class="fas fa-key"></i>
      <input id="contrasenaUsuario" type="password" placeholder="Contraseña" required name="contrasena">
    </div>
    <div>
      <button id="btn-login" class="ingresar" type="submit" value="guardar">Ingresar</button>
    </div>
  </form>

</div>
<div class="registro">
    <a href="registroServlet"><p>Registrarse</p></a>
</div>
</body>

</html>
