/**
 * 该方法主要针对使用ajax来进行文件下载
 * 例：
 * Ext.downloadFile({
     url:'xxx/xxx/xx.do',
     method:'POST',
     params:{}
 * });
 */
Ext.downloadFile = function(config){
	config = config || {};
    var url = config.url,
        method = config.method || 'POST',// Either GET or POST. Default is POST.
        params = config.params || {};

    // Create form panel. It contains a basic form that we need for the file download.
    var form = Ext.create('Ext.form.Panel', {
        standardSubmit: true,
        url: url,
        method: method
    });

    // Call the submit to begin the file download.
    form.submit({
       //target: '_blank', // Avoids leaving the page. 
        params: params
    });

    // Clean-up the form after 100 milliseconds.
    // Once the submit is called, the browser does not care anymore with the form object.
    Ext.defer(function(){
        form.close();
    }, 100);
    
}
