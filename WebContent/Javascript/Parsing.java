require([
			"dojox/mobile/parser",
			"dojox/mobile/compat",
			"dojo/domReady!",
			"dojox/mobile/View",
			"dojox/mobile/Heading",
			"dojox/mobile/RoundRectList",
            "dojox/mobile/RoundRect",
			"dojox/mobile/ListItem",
			"dojox/mobile/Switch",
			"dojox/mobile/RoundRectCategory",
            "dojox/mobile/TabBarButton",
            "dojox/mobile/TabBar",
            "dojox/mobile/ScrollableView",
            "dojox/mobile/FormLayout",
            "dojox/mobile/TextBox",
            "dojox/mobile/Button",
            "dojox/mobile/ComboBox"
		], function (parser) {
			// now parse the page for widgets
			parser.parse();
		});