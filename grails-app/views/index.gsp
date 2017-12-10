<!doctype html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Bubbazon</title>

    <asset:link rel="icon" href="favicon.ico" type="image/x-ico" />
</head>
<body>
    <content tag="nav">
        <li class="dropdown">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Application Status <span class="caret"></span></a>
            <ul class="dropdown-menu">
                <li><a href="#">Environment: ${grails.util.Environment.current.name}</a></li>
                <li><a href="#">App profile: ${grailsApplication.config.grails?.profile}</a></li>
                <li><a href="#">App version:
                    <g:meta name="info.app.version"/></a>
                </li>
                <li role="separator" class="divider"></li>
                <li><a href="#">Grails version:
                    <g:meta name="info.app.grailsVersion"/></a>
                </li>
                <li><a href="#">Groovy version: ${GroovySystem.getVersion()}</a></li>
                <li><a href="#">JVM version: ${System.getProperty('java.version')}</a></li>
                <li role="separator" class="divider"></li>
                <li><a href="#">Reloading active: ${grails.util.Environment.reloadingAgentEnabled}</a></li>
            </ul>
        </li>
        <li class="dropdown">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Artefacts <span class="caret"></span></a>
            <ul class="dropdown-menu">
                <li><a href="#">Controllers: ${grailsApplication.controllerClasses.size()}</a></li>
                <li><a href="#">Domains: ${grailsApplication.domainClasses.size()}</a></li>
                <li><a href="#">Services: ${grailsApplication.serviceClasses.size()}</a></li>
                <li><a href="#">Tag Libraries: ${grailsApplication.tagLibClasses.size()}</a></li>
            </ul>
        </li>
        <li class="dropdown">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Installed Plugins <span class="caret"></span></a>
            <ul class="dropdown-menu">
                <g:each var="plugin" in="${applicationContext.getBean('pluginManager').allPlugins}">
                    <li><a href="#">${plugin.name} - ${plugin.version}</a></li>
                </g:each>
            </ul>
        </li>
    </content>

    <div class="svg" role="presentation">
        <div class="grails-logo-container">
            <asset:image src="bubbazon.svg" class="grails-logo"/>
        </div>
    </div>

    <div id="content" role="main">
        <section class="row colset-2-its">
            <h1>BUBBAZON</h1>

            <p>
                Hi there.  Welcome to Bubbazon.  We sell everything for the modern Bubba.
            </p>

            <div id="controllers" role="navigation">
                <div class="container">
                    <div class="row">
                        <div class="col-sm-6">
                            <asset:image src="product.svg" width="50" height="50" align="right"/>
                        </div>
                        <div class="col-sm-6 col-right">
                            <g:link controller="product" action="browse">Browse Products</g:link>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-sm-6">
                            <asset:image src="product.svg" width="50" height="50" align="right"/>
                        </div>
                        <div class="col-sm-6 col-right">
                            <g:link controller="product">Manage Products</g:link>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-sm-6">
                            <asset:image src="folder.svg" width="50" height="50" align="right"/>
                        </div>
                        <div class="col-sm-6 col-right">
                            <g:link controller="category">Manage Categories</g:link>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-sm-6">
                            <asset:image src="factory.svg" width="50" height="50" align="right"/>
                        </div>
                        <div class="col-sm-6 col-right">
                            <g:link controller="manufacturer">Manage Manufacturers</g:link>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-sm-6">
                            <asset:image src="order.svg" width="50" height="50" align="right"/>
                        </div>
                        <div class="col-sm-6 col-right">
                            <g:link controller="productOrder">Manage Orders</g:link>
                        </div>
                    </div>
                </div>
            </div>
        </section>
    </div>

</body>
</html>
