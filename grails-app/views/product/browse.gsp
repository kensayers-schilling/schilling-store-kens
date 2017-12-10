<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'product.label', default: 'Product')}" />
        <title><g:message code="default.list.label" args="[entityName]" /></title>
        <asset:javascript src="fp.js"/>
        <asset:stylesheet src="fp.css"/>
    </head>
    <body>
        <a href="#list-product" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
        <filterpane:isFiltered>
            <filterpane:currentCriteria domainBean="Product" dateFormat="${[title: 'MM/dd/yyyy', releaseDate: 'MMM dd, yyyy']}"
                                        removeImgDir="images" removeImgFile="bullet_delete.png" fullAssociationPathFieldNames="no"/>
        </filterpane:isFiltered>
        <div id="list-product" class="content scaffold-list" role="main">
            <h1><g:message code="default.list.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
                <div class="message" role="status">${flash.message}</div>
            </g:if>
            <ul>
                <g:each in="${productList}" var="product">
                    <li>
                        <img id="image" name="image" src="<g:createLink controller="product" action="productImage" id="${product.id}"/>" width="100"/>
                        <g:link action="view" id="${product.id}">${product.name}</g:link>
                         ${product.price}
                    </li>
                </g:each>
            </ul>

            <filterpane:filterPane
                    domain="Product"
                    associatedProperties="category.name, manufacturer.name"
                    filterPropertyValues="${['category':[values:categoryList],
                                             'manufacturer':[values:manufacturerList]]}"
                    action="filterForBrowse"
                    dialog="true"
                    listDistinct="true"
                    fullAssociationPathFieldNames="false"
            />
            <div class="pagination">
                <filterpane:paginate total="${productCount ?: 0}" domainBean="Product"/>
                <filterpane:filterButton text="Filter Products" />
            </div>
        </div>
    </body>
</html>