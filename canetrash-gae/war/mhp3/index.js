Ext.setup({
    icon: 'icon.png',
    glossOnIcon: false,

    onReady: function() {
        Ext.getBody().mask('Loading...', 'loading', false);
        Ext.Ajax.request({
            url: 'huntingpipe.json',
            success: function(response, opts) {
                var jsonData = Ext.decode(response.responseText);
                var menus = [];
                var tpl = Ext.XTemplate.from('pipe');
                Ext.each(jsonData.pipes, function(pipe, num, items){
                    var html = tpl.applyTemplate(pipe);
                    var kinds = pipe.kinds;
                    menus.push({
                        text: "<span style='letter-spacing:-3px;font-size:20px;color:#" + pipe.color1 + ";'>♪</span> <span style='letter-spacing:-3px;font-size:20px;color:#" + pipe.color2 + ";'>♪</span> <span style='letter-spacing:-3px;font-size:20px;color:#" + pipe.color3 + ";'>♪</span>",
                        handler: function(btn, event) {
                            // コンテンツの処理
                            Ext.getCmp('content').update(html);
                            Ext.getCmp('overlay').update(kinds);
                            if (Ext.getCmp('fblike').isVisible()) {
                                Ext.getCmp('fblike').setVisible(false);
                            }
                        }
                    });
                }, this);
                panel.addDocked({
                    dock: 'top',
                    xtype: 'toolbar',
                    scroll: 'horizontal',
                    layout: 'hbox',
                    items: menus
                });
                Ext.getBody().unmask();
            }
        });
        // overlay
        var overlay = new Ext.Panel({
            id: 'overlay',
            floating: true,
            modal: true,
            centered: false,
            html: '音色を選んでください',
            width: Ext.is.Phone ? 200 : 400,
            height: Ext.is.Phone ? 220 : 400,
            styleHtmlContent: true,
            dockedItems: new Ext.Toolbar({
                dock: 'top',
                title: '笛'
            }),
            scroll: 'vertical',
            cls: 'htmlcontent'
        });
        var showOverlay = function(btn, event) {
            overlay.setCentered(false);
            overlay.showBy(btn);
        };
        
        var panel = new Ext.Panel({
            fullscreen: true,
            id: 'content',
            scroll: 'vertical',
            baseCls: 'content',
            html: '<img style="position:absolute; bottom: 10px; left:10px;" src="QRcode.gif"/><div class="title">旋律リファレンス</div>',
            dockedItems: [
            {
                id: 'status',
                xtype: 'toolbar',
                dock: 'bottom',
                items: [
                    {text: "この音色の笛", handler: showOverlay},
                    {xtype: 'spacer'},
                    {
                        id: 'fblike',
                        html: '<iframe src="http://www.facebook.com/plugins/like.php?href=http%3A%2F%2Fcanetrash.appspot.com%2Fmhp3%2Findex.html&amp;layout=button_count&amp;show_faces=false&amp;width=100&amp;action=like&amp;colorscheme=light&amp;height=21" scrolling="no" frameborder="0" style="border:none; overflow:hidden; width:70px; height:21px;" allowTransparency="true"></iframe>'
                    }
                ]
            }]
        });
    }
});
