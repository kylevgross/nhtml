define(['baja!',
        'bajaux/mixin/subscriberMixIn',
        'bajaux/Widget',
    ],
    function (
        baja,
        subscriberMixIn,
        Widget) {

        'use strict';

        var NhtmlWidget = function () {
            Widget.apply(this, arguments);
            subscriberMixIn(this);
        };

        var originalHyperlink = null;

        NhtmlWidget.prototype = Object.create(Widget.prototype);
        NhtmlWidget.prototype.constructor = NhtmlWidget;

        var globalComponent = null;

        var widgetLoad = async function(widget, component) {
            var fromWorkbench = window.niagara.env.type == 'wb'
            if (!fromWorkbench) {
                window.top.location.href = '/nhtml';
            }
            window.top.hyperlinkWindow = undefined;
            if (originalHyperlink === null) {
                originalHyperlink = window.niagara.env.hyperlink;
            }
            window.niagara.env.hyperlink = function (ordStr, assign) {
                if (window.top.hyperlinkWindow === undefined
                    || window.top.hyperlinkWindow === null
                    || window.top.hyperlinkWindow.location === null
                    || window.top.hyperlinkWindow.location === undefined
                    || window.top.hyperlinkWindow.location.assign === null
                    || window.top.hyperlinkWindow.location.assign === undefined
                    || typeof window.top.hyperlinkWindow.location.assign !== 'function') {
                    return originalHyperlink(ordStr, assign);
                } else {
                    return window.niagara.env.toHyperlink(ordStr)
                        .then(function (uri) {
                            if (typeof assign === "function") {
                                assign(uri);
                            } else {
                                window.top.hyperlinkWindow.location.assign(uri);
                            }
                        });
                }
            }
            var src = "/nhtml";
            var iframe = document.getElementById('nhtml_iframe');
            var iframeWindow = iframe.contentWindow || iframe.contentDocument.defaultView;
            iframe.onload = function (event) {
                if (iframeWindow.window.injectBaja) {
                    iframeWindow.window.injectBaja(fromWorkbench, widget);
                }
            }
            iframe.src = src;
        }

        NhtmlWidget.prototype.doInitialize = function (dom) {
            var fromWorkbench = window.niagara.env.type == 'wb'
            if (!fromWorkbench) {
                window.top.location.href = '/nhtml';
            }
            dom.html('<iframe src="about:blank" border="0" id="nhtml_iframe" style="border: none; position: absolute; top: 0px; bottom: 0px; left: 0px; right: 0px; height: 100%; width: 100%;"></iframe>')
            if(globalComponent){
                widgetLoad(this, globalComponent);
            }
        };

        NhtmlWidget.prototype.doLoad = async function (component) {
            globalComponent = await component.getNavOrd();
            widgetLoad(this, globalComponent);
        };

        NhtmlWidget.prototype.doDestroy = function () {
            window.hyperlinkWindow = null;
            var iframe = document.getElementById('nhtml_iframe');
            var iframeWindow = iframe.contentWindow || iframe.contentDocument.defaultView;
            if (iframeWindow.window.destroyApp) {
                iframeWindow.window.destroyApp();
            }
        };

        return NhtmlWidget;
    });