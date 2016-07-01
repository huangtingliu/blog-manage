/**
 * 定义了一个背景透明的Button类
 */
Ext.define('Widget.button.TransparentButton', {
			extend : 'Ext.button.Button', // 继续于Ext.button.Button
			alias : 'widget.transparent_button', // 此类的xtype类型为buttontransparent
			disableMouseOver : false,

			listeners : {
				// 鼠标移开，背景设置透明
				mouseout : function() {
					this.setTransparent(document.getElementById(this.id));
				},
				// 鼠标移过，背景取消透明
				mouseover : function(button) {
					var b = document.getElementById(this.id);
					if (!button.disableMouseOver) {
						b.style.backgroundImage = '';
						b.style.backgroundColor = '';
						b.style.borderColor = '';
					} else
						b.style.borderColor = '';
				},
				// 背景设置透明
				afterrender : function() {
					this.setTransparent(document.getElementById(this.id));
				}
			},
			setTransparent : function(b) {
				b.style.backgroundImage = 'inherit';
				b.style.backgroundColor = 'inherit';
				b.style.borderColor = 'transparent';
			}
		});