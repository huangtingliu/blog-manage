/**
 * ckeditor_4.6.2 整合 extjs
 * 例：
     xtype: 'ckeditor', 
     fieldLabel: '内容', 
     labelAlign: 'right', 
     height: 120, 
     width:463, 
     name: 'content', 
     id:'newsckeditor', 
     CKConfig: {} 
 */
Ext.define("Ux.form.field.CKEditor", {
    extend: 'Ext.form.field.TextArea',
    alias: 'widget.ckeditor',
    _CKConfig:{
		language:'zh-cn',
		baseFloatZIndex: 99999,      //如果选择字体样式等的弹出窗口被当前window挡住，就设置这个为一个较大的值 
		resize_enabled  : false,    //“拖拽以改变尺寸”的功能  
		removePlugins : 'elementspath', //清除底边的状态栏
		toolbar:[
		    ['Undo','Redo'],
		    ['Bold','Italic','Strike','NumberedList','BulletedList','Blockquote'],
		    ['Link','Table','PageBreak','HorizontalRule','SpecialChar','Image']
		]
	},
    constructor : function() {
    	this.callParent(arguments);
    },
    initComponent: function () {
        this.callParent(arguments);
    },
    onRender: function (ct, position) {
        if (!this.el) {
            this.defaultAutoCreate = {
                tag: 'textarea',
                autocomplete: 'off'
            };
        }
        this.callParent(arguments)
    },
    onDestroy: function(){
        if (CKEDITOR.instances[this.id]) {
          delete CKEDITOR.instances[this.id];
        }
    },
    isDirty : function() {
        if(this.disabled) {
          return false;
        }
        var value = String(this.getValue()).replace(/\s/g,'');
        value = (value == "<br />" || value == "<br/>" ? "" : value);
        this.originalValue = this.originalValue || "";
        this.originalValue = this.originalValue.replace(/\s/g,'');
        return String(value) !== String(this.originalValue) ? String(value) !== "<p>"+String(this.originalValue)+"</p>" : false;
    },
    setValue: function (value) {
        this.callParent(arguments);
        if (this.editor) {
            this.editor.setData(value);
        }
    },
    getRawValue: function () {//要覆盖getRawValue方法，否则会取不到值
        if (this.editor) {
            return this.editor.getData();
        } else {
            return ''
        }
    },
    getValue: function () {
        return this.getRawValue();
    },
    listeners:{
    	afterrender:function(){
    	     var triggerWrap = Ext.get(this.getId()+"-triggerWrap");  
    	     triggerWrap.setStyle("border-color","white");
    	     if(Ext.isEmpty(this.CKConfig)){
    	    	 this.CKConfig = this._CKConfig;
    	     }else{
    	    	 Ext.apply(this.CKConfig,this._CKConfig);
    	     }
    	     Ext.apply(this.CKConfig,{
    	    	 height:this.getHeight()
    	     })
    	     
		   //  CKEDITOR.replace("myfield",{customConfig : "ckeditor/config.js"}); //CKeditor的配置文件 若不想配置 留空即可  
		     this.editor = CKEDITOR.replace(this.inputEl.id, this.CKConfig);
		     this.editor.name = this.name;//把配置中的name属性赋值给CKEditor的name属性
		     
		     this.editor.on("instanceReady", function(){
		         this.fireEvent("instanceReady", this, this.editor);//触发instanceReady事件
		     }, this);
    	},
    	resize:function(){
    	  console.info("resize...............");
    	  //this.editor.resize(w - t.getLabelWidth(), h-18);
    	},
    	autosize:function(){
    		  console.info("autosize...............");
    	},
    	instanceReady:function(_self,editor){
    		// todo...
    	}
    }
});

/**
    /  =  换行                   Templates = 模板            		Source = 源码模式
    - =  分割线                   Cut = 剪切						Copy = 复制
	Save = 保存(提交表单)			Paste = 粘贴						PasteFromWord = 从 MS WORD 粘贴
	NewPage = 新建				PasteText = 粘贴为无格式文本			Print = 打印
	Preview = 预览				SpellChecker = 拼写检查			Scayt = 即时拼写检查
	Undo = 撤销					RemoveFormat = 清除格式			Form = 表单
	Redo = 重做					Form = 表单						Radio = 单选框
	Find = 查找					Radio = 单选框					Radio = 单选框
	Replace = 替换				Select = 列表/菜单					Strike = 删除线
	SelectAll = 全选				Underline = 下划线				Subscript = 下标
	Button = 按钮					Italic = 倾斜						BulletedList = 项目列表
	ImageButton = 图片按钮			Superscript = 上标				NumberedList = 编号列表
	HiddenField = 隐藏域			CreateDiv = 创建DIV容器			JustifyLeft = 左对齐
	Bold = 加粗					JustifyCenter = 居中				JustifyRight = 右对齐
	Outdent = 减少缩进量			JustifyBlock = 两端对齐			BidiLtr = 文字方向从左到右
	Indent = 增加缩进量				BidiRtl = 文字方向从右到左			Link = 插入/编辑超链接(上传文件)
	Blockquote = 块引用			Flash = 动画(上传)					Table = 表格
	Unlink = 取消超链接				HorizontalRule = 插入水平线			SpecialChar = 插入特殊符号
	Anchor = 插入/编辑锚点链接		PageBreak = 插入分页符				Styles = 样式快捷方式
	Image = 图像(上传)				TextColor = 文字颜色				BGColor = 背景颜色
	Smiley = 插入表情				Maximize = 全屏编辑模式				ShowBlocks = 显示区块
	Format = 文本格式				Font = 字体						FontSize = 文字大小
	About = 显示关于
	
	language:'zh-cn',
    skin:'kama', 					 //[kama,office2003,v2] 默认皮肤(kama)
    uiColor:'#FFF', 				 //背景颜色  
	toolbar:[ 						 //工具栏（基础'Basic'、全能'Full'、自定义）
	    ['Undo','Redo'],
	    ['Bold','Italic','Strike','NumberedList','BulletedList','Blockquote'],
	    ['Link','Table','PageBreak','HorizontalRule','SpecialChar','Image']
	],
	toolbarCanCollapse:false,		 //工具栏是否可以被收缩 
	baseFloatZIndex: 99999,    		 //如果选择字体样式等的弹出窗口被当前window挡住，就设置这个为一个较大的值 
	toolbarStartupExpanded:false,  	 //工具栏默认是否展开  
	resize_enabled : false,   		 //取消“拖拽以改变尺寸”的功能  
	resize_maxHeight : 3000,    	 //改变大小的最大高度  
	toolbarLocation:'bottom',     	//工具栏的位置  
	resize_minWidth : 3000,   		//改变大小的最大宽度
    resize_minHeight : 250, 		 //改变大小的最小高度  
    resize_minWidth : 750,  		//改变大小的最小宽度  
	autoUpdateElement : true; 		//当提交包含有此编辑器的表单时，是否自动更新元素内的数据    
	baseHref : "";   				//设置是使用绝对目录还是相对目录，为空为相对目录  
	baseFloatZIndex : 10000;   	   //编辑器的z-index值  
	keystrokes : [];   				//设置快捷键  
	blockedKeystrokes : [];   		//设置快捷键 可能与浏览器快捷键冲突  
	colorButton_backStyle : {  		 //设置编辑内元素的背景色的取值  
		element : 'span',  
		styles : {'background-color' : '#(color)'}  
	}  
	colorButton_colors   				 //设置前景色的取值  
	colorButton_enableMore = false;     //是否在选择颜色时显示“其它颜色”选项  
	colorButton_foreStyle = {  			  //前景色默认值设置  
		element : 'span',  
		styles : {'background-color' : '#(color)'}  
	}  
	contentsCss = "ckeditor/contents.css"    //所需要添加的CSS文件 在此添加 可使用相对路径和网站的绝对路径  
	contentsLangDirection = "rtl";   		 //文字方向  
	dialog_backgroundCoverColor = "rgb(a,b,c)";   //界面编辑框的背景色  
	dialog_backgroundCoverColor = "white";  
	dialog_backgroundCoverOpacity = 0.5;   //背景的不透明度  
	dialog_magnetDistance = 20;   		 //移动或者改变元素时 边框的吸附距离 单位：像素  
	disableNativeSpellChecker = true;     //是否拒绝本地拼写检查和提示 默认为拒绝 目前仅firefox和safari支持  
	disableNativeTableHandles = true; 		默认不开启   //进行表格编辑功能 如：添加行或列 目前仅firefox支持  
	docType = '<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">';   //设置HTML文档类型  
	editingBlock = true;  				 //是否对编辑区域进行渲染  
	enterMode = CKEDITOR_ENTER_BR;   	//编辑器中回车产生的标签  
	entities = true;  					 //是否使用HTML实体进行输出  
	entities_additional = "#1049";  	 //定义更多的实体  
	entities_greek = true;  			  //是否转换一些难以显示的字符为相应的HTML字符  
	entities_latin = true;   			//是否转换一些拉丁字符为HTML  
	entities_processNumerical = false;	 //是否转换一些特殊字符为ASCII字符    
	extraPlugins = "myplugin"; 			  //添加新组件  
	find_highlight = {   						//使用搜索时的高亮色  
		element : "span",  
		style : {"background-color" : "#ff0", "color" : "#00f"}  
	}  
	font_defaultLabel = "Arial";  			 //默认的字体名  
	font_names = "Arial;Times New Roman;Verdana";   //字体编辑时的字符集 可以添加常用的中文字符：宋体、楷体、黑体等  
	font_style = {}; 							  //文字的默认式样  
	fontSize_defaultLabel = "12px";  			//字体默认大小  
	//字体编辑时可选的字体大小  
	fontSize_sizes = "8/8px;9/9px;10/10px;11/11px;12/12px;14/14px;16/16px;18/18px;20/20px;22/22px;24/24px;26/26px;28/28px;36/36px;48/48px;72/72px";  
	fontSize_style = {};   					//设置字体大小时 使用的式样  
	forcePasteAsPlainText = false;//不去除   //是否强制复制来的内容去除格式  
	forceSimpleAmpersand = false;  			 //是否强制用“&”来代替“&”  
	format_address = { element : 'address', attributes : { class : 'styledAddress' } };    //对address标签进行格式化  
	format_div = { element : 'div', attributes : { class : 'normalDiv' } };   //对DIV标签自动进行格式化  
	format_h1 = { element : 'h1', attributes : { class : 'contentTitle1' } };   //对H1标签自动进行格式化  
	format_h2 = { element : 'h2', attributes : { class : 'contentTitle2' } };   //对H2标签自动进行格式化 
	format_h3 = { element : 'h3', attributes : { class : 'contentTitle3' } };   //对H3标签自动进行格式化  
	format_h4 = { element : 'h4', attributes : { class : 'contentTitle4' } };  //对H4标签自动进行格式化  
	format_h5 = { element : 'h5', attributes : { class : 'contentTitle5' } };   //对H5标签自动进行格式化  
	format_h6 = { element : 'h6', attributes : { class : 'contentTitle6' } };  //对H6标签自动进行格式化  
	format_p = { element : 'p', attributes : { class : 'normalPara' } };  	 //对P标签自动进行格式化  
	format_pre = { element : 'pre', attributes : { class : 'code' } };  //对PRE标签自动进行格式化  
	format_tags = "p;h1;h2;h3;h4;h5;h6;pre;address;div";  //用分号分隔的标签名字 在工具栏上显示
	fullPage = false;     //是否使用完整的html编辑模式 如使用，其源码将包含：<html><body></body></html>等标签  
	ignoreEmptyParagraph = true;  			 //是否忽略段落中的空字符  
	image_removeLinkByEmptyURL = true;  //在清除图片属性框中的链接属性时 是否同时清除两边的<a>标签  
	//一组用逗号分隔的标签名称，显示在左下角的层次嵌套中  
	menu_groups ='clipboard,form,tablecell,tablecellproperties,tablerow,tablecolumn,table,anchor,link,image,flash,checkbox,radio,textfield,hiddenfield,imagebutton,button,select,textarea';  
	menu_subMenuDelay = 400;   //显示子菜单时的延迟，单位：ms  
	newpage_html = "";     //当执行“新建”命令时，编辑器中的内容 
	pasteFromWorldIgnoreFontFace = true; //默认忽略格式   //当从word里复制文字进来时，是否进行文字的格式化去除   
	pasteFromWorkKeepsStructure = false;   //是否使用<h1><h2>等标签修饰或者代替从word文档中粘贴过来的内容  
	pasteFromWorkRemoveStyle = false;  //从word中粘贴内容时是否移除格式  
	protectedSource.push( /<\?[\s\S]*?\?>/g );   // PHP code   //对应后台语言的类型来对输出的HTML内容进行格式化，默认为空 
	protectedSource.push( /<%[\s\S]*?%>/g );   // ASP code  
	protectedSource.push( /(]+>[\s|\S]*?<\/asp:[^\>]+>)|(]+\/>)/gi );   // ASP.Net code  
	shiftEnterMode = CKEDITOR.ENTER_P;    //当输入：shift+Enter时插入的标签  
	smiley_descriptions = [   //可选的表情替代字符  
	        ':)', ':(', ';)', ':D', ':/', ':P',  
	        '', '', '', '', '', '',  
	       '', ';(', '', '', '', '',  
	       '', ':kiss', '' ];  
	smiley_images = [    //对应的表情图片  
	      'regular_smile.gif','sad_smile.gif','wink_smile.gif','teeth_smile.gif','confused_smile.gif','tounge_smile.gif',  
	      'embaressed_smile.gif','omg_smile.gif','whatchutalkingabout_smile.gif','angry_smile.gif','angel_smile.gif','shades_smile.gif',  
	      'devil_smile.gif','cry_smile.gif','lightbulb.gif','thumbs_down.gif','thumbs_up.gif','heart.gif',  
	      'broken_heart.gif','kiss.gif','envelope.gif'];  
	smiley_path = "plugins/smiley/images";     //表情的地址
	startupForce = false;    //页面载入时，编辑框是否立即获得焦点  
	startupMode = "wysiwyg";   //载入时，以何种方式编辑 源码和所见即所得 "source"和"wysiwyg"  
	startupOutlineBlocks = false;    //载入时，是否显示框体的边框  
	undoStackSize = 20;    //撤销的记录步数  
	theme = "default";   //主题 
	tabIndex = 0;  //起始的索引值 
	tabSpaces = 4;   //当用户键入TAB时，编辑器走过的空格数，( ) 当值为0时，焦点将移出编辑框  
	templates = "default";   //默认使用的模板  
	templates_files = ['plugins/templates/templates/default.js'];   //用逗号分隔的模板文件  
	templates_replaceContent = true;  //当使用模板时，“编辑内容将被替换”框是否选中  
	stylesSet = 'mystyles';  //是否载入样式文件  
	stylesSet = 'mystyles:/editorstyles/styles.js';    // Load from a relative URL.  
	stylesSet = 'mystyles:http://www.example.com/editorstyles/styles.js';   // Load from a full URL.  
	stylesSet = [   // Load from a list of definitions.  
	   { name : 'Strong Emphasis', element : 'strong' },  
	   { name : 'Emphasis', element : 'em' }, ... ];  
	contentsCss = "/CKEditorAndCKFinder/ckeditor/css/mysitestyles.css"; 
*/