<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>发布博文</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="blog login page">
	<link rel="stylesheet" href="${resRoot}/plugins/editor.md-master/css/editormd.css">
  </head>
  
  <body>
  	<%@include file="../comm/header.jsp" %>
  	<div id="layout">
	  	<header>
	  		<h1>发布博文</h1>
	  	</header>
		<div id="test-editormd">
			<textarea style="display:none;">
[TOC]

#### Disabled options:kissing:

- TeX (Based on KaTeX);
- Emoji;
- Task lists;
- HTML tags decode;
- Flowchart and Sequence Diagram;
------------
```js
function get(){
    alert(233)
}
```
#### Editor.md directory

    editor.md/
            lib/
            css/
            scss/
            tests/
            fonts/
            images/
            plugins/
            examples/
            languages/     
            editormd.js
            ...
#### 表格
- [x] GFM task list 1
| Left-Aligned  | Center Aligned  | Right Aligned |
| :------------ |:---------------:| -----:|
| col 3 is      | some wordy text | $1600 |
| col 2 is      | centered        |   $12 |
| zebra stripes | are neat        |    $1 |

```html
&lt;!-- English --&gt;
&lt;script src="../dist/js/languages/en.js"&gt;&lt;/script&gt;

&lt;!-- 繁體中文 --&gt;
&lt;script src="../dist/js/languages/zh-tw.js"&gt;&lt;/script&gt;
```
#### 图片
[![](https://pandao.github.io/editor.md/examples/images/7.jpg)](https://pandao.github.io/editor.md/images/7.jpg "李健首张专辑《似水流年》封面")
> 图为：李健首张专辑《似水流年》封面
			</textarea>
		</div>    
		<button onclick="getMarkdown()">获取markdown</button>
		<button onclick="getHTML()">获取HTML</button>
		<button onclick="getPreviewedHTML()">获取预览窗口HTML</button>
		<button id="undo">undo</button>
    </div>
    
    <%@include file="../comm/comm.jsp" %>
    <script type="text/javascript" src="${resRoot}/plugins/editor.md-master/editormd.min.js"></script>
  	<script type="text/javascript">
  	var testEditor;	
  	$(function(){
  		testEditor = editormd("test-editormd", {
            width   : "90%",
            height  : 640,
            syncScrolling : "single",
            path    : "${resRoot}/plugins/editor.md-master/lib/",
            emoji :true,
            saveHTMLToTextarea:true,
            toolbarCustomIcons :{
            	info:"" //取消关于工具
            },
            //上传图片
            imageUpload    : true,
            imageFormats   : ["jpg", "jpeg", "gif", "png", "bmp"],
            imageUploadURL : "${ctxPath}/ajax/upload/",
            message :"ssdsds"
        });
  		
  		//外部定义一个按钮事件模仿工具栏按钮效果
  		$("#undo").bind('click', function() {
  		    $.proxy(testEditor.toolbarHandlers.undo, testEditor)();
  		});
	});
  	
  	function getMarkdown(){
  		var markdown =testEditor.getMarkdown(); // 获取 Markdown 源码
  		alert(markdown);
  	}
  	function getHTML(){
  		// 获取 Textarea 保存的 HTML 源码,saveHTMLToTextarea要设置为true
  		var html = testEditor.getHTML();
  		alert(html);
  	}
  	function getPreviewedHTML(){
  		// 获取预览窗口里的 HTML，在开启 watch 且没有开启 saveHTMLToTextarea 时使用
  		var previewedHTML = testEditor.getPreviewedHTML();
  		alert(previewedHTML);
  	}
  	</script>
  </body>
</html>
