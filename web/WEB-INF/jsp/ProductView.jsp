<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>View Product</title>
    <%--<link href="css/main.css" rel="stylesheet" />--%>
    <style type="text/css">@import url("<c:url value="/css/main.css"/>");</style>
</head>
<body>
<div id="global">
    <h4>${message}</h4>

    <p>
    <h5>Details:</h5>
    Product Name:${product.name}<br/>
    Description:${product.description}<br/>
    Price:$${product.price}
    </p>
</div>
</body>
</html>