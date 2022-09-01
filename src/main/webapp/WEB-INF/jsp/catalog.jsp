<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<title> Catalog </title>
    <style>
        .left {
            float: left;
        }
        .right {
            float: right;
        }
        table, th, td { border: 1px solid;}
    </style>
</head>
<body>

    <p align="center">
        WELCOME, ${user.firstName}
    <div align="center">
    <form action="/logout" method="get">
        <input type="submit" value = "Log Out">
    </form>
    </div>

    </p>
    <p align="center">
        Everything is very tasty and fresh. Order whatever you like.
    </p>

<section>
    <code>
<div class="left">

<p align="center">
    AVAILABLE TODAY
</p>

    <table>
        <tr>
            <th>
                Product name
            </th>
            <th>
                Price per portion $
            </th>
            <th>
                Description
            </th>
            <th>
                Add to cart button :)
            </th>

        </tr>
        <c:forEach var = "prod" items ="${product}">
            <tr>
                <td>
                        ${prod.name}
                </td>
                <td>
                        ${prod.price}
                </td>
                <td>
                        ${prod.description}
                </td>
                <td>
                    <form action="/add"  method = "POST">
                        <input type ="hidden" value = "${prod.id}" name = "product">
                        <input type = "submit" value = "Add to cart">

                    </form>
                </td>
            </tr>
        </c:forEach>


    </table>
</div>

</code>
</section>
<aside>
    <code>
<div class="right">
     <p align="center">
    CART
     </p>
    <table>
        <tr>
            <th>
                Product name
            </th>
            <th>
                Price per portion
            </th>
            <th>
                Quantity
            </th>
            <th>
                Price per position
            </th>
            <th>
                Delete product
            </th>
        </tr>
        <c:forEach var = "cartEntry" items = "${cart.cartEntry}">
            <tr>
                <td>
                    ${cartEntry.product.name}
                </td>
                <td>
                    ${cartEntry.product.price}
                </td>
                <td>
                    ${cartEntry.quantity}
                </td>
                <td>
                    ${cartEntry.totalPrice}
                </td>
                <td>
                    <form action = "/delete" method ="POST">
                        <input type= "hidden" value = "${cartEntry.product.id}" name = "productId">
                        <input type = "submit" value = "Delete">
                    </form>
                </td>
            </tr>

        </c:forEach>
    </table>

</div>

    </code>
</aside>
<p align="center">
</p>
</body>

</html>
