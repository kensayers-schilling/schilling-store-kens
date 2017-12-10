<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'productOrder.label', default: 'ProductOrder')}" />
        <title><g:message code="default.list.label" args="[entityName]" /></title>
    </head>
    <body>
        <a href="#list-productOrder" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
        <div class="nav" role="navigation">
            <ul>
                <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
                <li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
            </ul>
        </div>
        <div id="list-productOrder" class="content scaffold-list" role="main">
            <h1><g:message code="default.list.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
                <div class="message" role="status">${flash.message}</div>
            </g:if>
            <table class="report">
                <tr><th>Number</th><th>Product</th></tr>
                <g:each in="${productOrderList}" var="productOrder">
                    <tr>
                        <td>${productOrder.number}</td>
                        <td>${productOrder.product.name}</td>
                    </tr>
                </g:each>
            </table>
            <!--
            <f:table collection="${productOrderList}" />
            <div class="pagination">
                <g:paginate total="${productOrderCount ?: 0}" />
            </div>
            -->
        </div>
    </body>
</html>