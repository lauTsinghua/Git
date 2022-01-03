/*ajax异步GET请求*/
function doAjaxGet(url, params, callback) {

    /*1.创建ajax异步请求(这也是ajax技术应用的入口对象)*/
    let xhr = new XMLHttpRequest();
    /*2.设置请求,响应过程的状态监听(通过回调函数处理状态变化)*/
    xhr.onreadystatechange = function () {
        if (xhr.readyState == 4 && xhr.status == 200) {/*4表示通讯结束,200表示响应成功*/
            callback(xhr.responseText);
        }
    };
    /*3.创建或打开与服务器端的状态链接(设置同步或者异步)*/
    xhr.open("Get", url + "?" + params, true);  //Get请求 true表示异步
    /*4.发送异步请求*/
    xhr.send(null);/*Get请求send方法进行传递的参数*/

}

/*ajax异步POST请求*/
function doAjaxPost(url, params, callback) {
    let xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function () {
        if (xhr.readyState == 4 && xhr.status == 200) {/*4表示通讯结束,200表示响应成功*/
            callback(xhr.responseText);
        }
    };
    /*3.创建或打开与服务器端的状态链接(设置同步或者异步)*/
    xhr.open("POST", url, params, true);   //POST请求 true表示异步
    xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");//POST请求头必须要写   Get请求不需要这串代码
    xhr.send(params);/*POST请求send方法进行传递的参数*/
}
