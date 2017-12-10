<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'product.label', default: 'Product')}" />
        <title><g:message code="default.show.label" args="[entityName]" /></title>
    </head>
    <body>
        <a href="#show-product" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
        <div class="nav" role="navigation">
            <ul>
                <li><g:link class="list" action="browse">Browse</g:link></li>
            </ul>
        </div>
        <div id="show-product" class="content scaffold-show" role="main">
            <h1><g:message code="default.show.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
               <div class="message" role="status">${flash.message}</div>
            </g:if>
            <g:if test="${this.product.imageBytes}">
                <div class="fieldcontain">
                    <label for="image">Image</label>
                    <img id="image" name="image" src="<g:createLink controller="product" action="productImage" id="${this.product.id}"/>" width="400"/>
                </div>
                <div class="fieldcontain">
                    <label >Name</label>
                    <g:field name="name" type="text" readonly="true" value="${product.name}"/>
                </div>
                <div class="fieldcontain">
                    <label for="description">Description</label>
                    <g:field name="description" type="text" readonly="true" value="${product.description}"/>
                </div>
                <div class="fieldcontain">
                    <label for="price">Price</label>
                    <g:textField name="price" readonly="true" value="${product.price}"/>
                </div>
            </g:if>
        </div>
    </body>
</html>
