webpackJsonp([1],{"0tIY":function(t,e){},"3ZmK":function(t,e){},"4JU1":function(t,e){},"5J3P":function(t,e){},"8L9t":function(t,e){},JC7E:function(t,e){},NHnr:function(t,e,a){"use strict";Object.defineProperty(e,"__esModule",{value:!0});var n=a("7+uW"),r={render:function(){var t=this.$createElement,e=this._self._c||t;return e("div",{attrs:{id:"app"}},[e("router-view")],1)},staticRenderFns:[]};var o=a("VU/8")({name:"App"},r,!1,function(t){a("adnM")},null,null).exports,s=a("/ocq"),l={data:function(){return{activeIndex:"Gadget"}},created:function(){this.$router.push("/"+this.activeIndex)},watch:{activeIndex:function(){this.$router.push("/"+this.activeIndex)}},methods:{handleSelect:function(t,e){console.log(t,e),this.activeIndex=t}}},i={render:function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("el-container",[a("el-header",{staticClass:"header-class"},[a("el-menu",{staticClass:"el-menu-demo",attrs:{"default-active":t.activeIndex,mode:"horizontal","background-color":"#36A5E2","text-color":"#fff","active-text-color":"#fefefe"},on:{select:t.handleSelect}},[a("el-menu-item",{staticClass:"menu-font",attrs:{index:"Gadget"}},[t._v("小玩意")]),t._v(" "),a("el-menu-item",{staticClass:"menu-font",attrs:{index:"Cockpit"}},[t._v("驾驶舱")]),t._v(" "),a("el-menu-item",{staticClass:"menu-font",attrs:{index:"FileBrowser"}},[t._v("文件浏览")]),t._v(" "),a("el-menu-item",{staticClass:"menu-font",attrs:{index:"QuickCommand"}},[t._v("快捷命令")])],1)],1),t._v(" "),a("el-main",[a("el-card",{staticClass:"box-card"},[a("router-view")],1)],1)],1)},staticRenderFns:[]};var c=a("VU/8")(l,i,!1,function(t){a("0tIY")},"data-v-3c435bb8",null).exports,u=a("//Fk"),d=a.n(u),p=a("mtWM"),f=a.n(p),h=a("zL8q"),m=a.n(h),v=f.a.create({baseURL:"/",timeout:6e4}),b=function(){Z.push({path:"/login",query:{backRouter:Z.currentRoute.fullPath}})};v.interceptors.request.use(function(t){return localStorage.getItem("token")&&(t.headers.Authorization=localStorage.getItem("token")),t},function(t){return console.log(t),d.a.reject(t)}),v.interceptors.response.use(function(t){if(200==t.status){var e=t.data;return 2e3==e.code?e.data:(Object(h.Message)({type:"error",message:e.message}),d.a.reject(e.data))}console.log("请求失败",t)},function(t){if(t.message.indexOf("timeout")>-1)return d.a.reject("请求超时了,请重试！");var e=t.response.status;if(e)switch(e){case 401:Object(h.Message)({type:"error",message:"暂无权限，请先登陆哦！"}),b();break;case 403:Object(h.Message)({type:"error",message:"登陆过期，请重新登陆！"}),localStorage.removeItem("token"),b();case 500:Object(h.Message)({type:"error",message:"服务器异常！"});default:console.log(t.code)}});var _=v,g={data:function(){return{files:[],currentPath:""}},created:function(){this.fetchData("")},methods:{sizeFormatter:function(t){return t.size+"B"},clickRowHandle:function(t){"directory"==t.fileType&&this.fetchData(t.name)},fetchData:function(t){var e=this;t.length>0&&(this.currentPath=this.currentPath+"/"+t),_({method:"get",url:"api/listResource?path="+this.currentPath}).then(function(t){return e.files=t.context})}}},C={render:function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("el-container",[a("el-header",[a("el-breadcrumb",{attrs:{separator:"/"}},t._l(t.currentPath.split("/"),function(e,n){return a("el-breadcrumb-item",{key:n},[t._v(t._s(e))])}),1)],1),t._v(" "),a("el-main",[a("el-table",{staticStyle:{width:"100%"},attrs:{data:t.files},on:{"row-dblclick":t.clickRowHandle}},[a("el-table-column",{attrs:{prop:"name",label:"文件名",width:"300"}}),t._v(" "),a("el-table-column",{attrs:{prop:"fileType",label:"文件类型",width:"180"}}),t._v(" "),a("el-table-column",{attrs:{prop:"size",formatter:t.sizeFormatter,label:"文件大小"}}),t._v(" "),a("el-table-column",{attrs:{prop:"modifyTime",width:"150",label:"修改时间"}}),t._v(" "),a("el-table-column",{attrs:{prop:"accessUrl",width:"450",label:"下载地址"},scopedSlots:t._u([{key:"default",fn:function(e){return[a("a",{attrs:{href:e.row.accessUrl}},[t._v(t._s(e.row.accessUrl))])]}}])})],1)],1)],1)},staticRenderFns:[]};var x=a("VU/8")(g,C,!1,function(t){a("3ZmK")},"data-v-1e693d5d",null).exports,y=a("NC6I"),w=a.n(y),A={data:function(){return{dialogVisible:!1,commands:[],result:[]}},created:function(){var t=this;_({method:"get",url:"api/listCommand"}).then(function(e){return t.commands=e})},methods:{open:function(t){var e=this;this.current=t,t.open?this.executeCommandHandle(t.id,""):this.$prompt("请输入密码","提示",{confirmButtonText:"确定",cancelButtonText:"取消"}).then(function(a){var n=a.value;e.executeCommandHandle(t.id,n)}).catch(function(){e.$message({type:"info",message:"取消执行"}),e.handleClose()})},executeCommandHandle:function(t,e){var a=this;_.post("api/executeCommand",{id:t,password:w()(e)}).then(function(t){a.result=t,a.dialogVisible=!0}).catch(function(t){return console.log(t)})},handleClose:function(){this.result=[]},tableRowClassName:function(t){var e=t.row;return"simple"==e.type?"warning-row":"pipeline"==e.type?"success-row":""}}},k={render:function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("el-container",[a("el-table",{staticStyle:{width:"100%"},attrs:{data:t.commands,"row-class-name":t.tableRowClassName}},[a("el-table-column",{attrs:{prop:"id",label:"id",width:"50"}}),t._v(" "),a("el-table-column",{attrs:{prop:"command",label:"命令",width:"250"}}),t._v(" "),a("el-table-column",{attrs:{prop:"description",label:"描述",width:"200"}}),t._v(" "),a("el-table-column",{attrs:{prop:"type",label:"类型",width:"180"}}),t._v(" "),a("el-table-column",{attrs:{prop:"workDir",label:"工作路径"}}),t._v(" "),a("el-table-column",{attrs:{fixed:"right",label:"操作",width:"100"},scopedSlots:t._u([{key:"default",fn:function(e){return[a("el-button",{attrs:{type:"text",size:"small"},on:{click:function(a){return t.open(e.row)}}},[t._v("执行")])]}}])})],1),t._v(" "),a("el-dialog",{attrs:{title:"执行结果",visible:t.dialogVisible,width:"60%","show-close":!1,"before-close":t.handleClose},on:{"update:visible":function(e){t.dialogVisible=e}}},[t._l(t.result,function(e,n){return a("div",{key:n},[a("h4",[t._v("命令："+t._s(e.command)+" 工作路径："+t._s(e.workDir)),a("br")]),t._v(" "),t._l(e.resultInfo,function(e,n){return a("span",{key:n},[t._v(t._s(e)+" "),a("br")])})],2)}),t._v(" "),a("span",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[a("el-button",{on:{click:function(e){t.dialogVisible=!1}}},[t._v("取 消")]),t._v(" "),a("el-button",{attrs:{type:"primary"},on:{click:function(e){t.dialogVisible=!1}}},[t._v("确 定")])],1)],2)],1)},staticRenderFns:[]};var V=a("VU/8")(A,k,!1,function(t){a("5J3P")},"data-v-8b823e64",null).exports,U={render:function(){var t=this.$createElement;return(this._self._c||t)("el-container")},staticRenderFns:[]};var E=a("VU/8")({data:function(){return{json:'{"name":"qiqiang"}'}}},U,!1,function(t){a("4JU1")},"data-v-5ab08ee8",null).exports,F={render:function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("el-container",[a("el-header",[a("el-row",t._l(t.items,function(e,n){return a("el-button",{key:n,attrs:{type:e.type,to:e.path,round:""},on:{click:function(a){return t.clickToolHandle(e)}}},[t._v(t._s(e.name))])}),1)],1),t._v(" "),a("el-main",[a("el-card",{staticClass:"box-card"},[a("router-view")],1)],1)],1)},staticRenderFns:[]};var S=a("VU/8")({data:function(){return{items:[{type:"primary",name:"加解密",path:"/Gadget/Codec"},{type:"success",name:"JSON",path:"/Gadget/JSON"},{type:"info",name:"正则编辑",path:"/Gadget/Codec"},{type:"danger",name:"做选择",path:"/Gadget/Codec"}]}},methods:{clickToolHandle:function(t){this.$router.push(t.path)}}},F,!1,function(t){a("fPG/")},"data-v-98b2aff0",null).exports,R=a("PXCl"),B=a("B0Pk"),P=a.n(B),I=a("BUS2"),$=a.n(I),z=a("qJME"),D=a.n(z),G=a("XinO"),H=a.n(G),T={data:function(){return{text:"",hint:"请输入字符",base64Encode:!0,lowerCase:!0}},methods:{copyValue:function(t){var e=this;t!=this.hint&&H()(t).then(function(t){e.$message({message:"复制成功",type:"success"})}).catch(function(t){e.$message({message:"复制失败",type:"error"})})}},computed:{md5Value:function(){if(0===this.text.length)return this.hint;var t=w()(this.text);return this.lowerCase?t:t.toUpperCase()},base64Value:function(){return 0===this.text.length?this.hint:this.base64Encode?R.a.encode(this.text):R.a.decode(this.text)},sha1Value:function(){if(0===this.text.length)return this.hint;var t=P()(this.text);return this.lowerCase?t:t.toUpperCase()},sha256Value:function(){if(0===this.text.length)return this.hint;var t=$()(this.text);return this.lowerCase?t:t.toUpperCase()},sha512Value:function(){if(0===this.text.length)return this.hint;var t=D()(this.text);return this.lowerCase?t:t.toUpperCase()}}},j={render:function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",[a("el-input",{attrs:{type:"textarea",rows:4,autosize:{minRows:4,maxRows:4},placeholder:"请输入字符"},model:{value:t.text,callback:function(e){t.text=e},expression:"text"}}),t._v(" "),a("el-switch",{staticClass:"val-title",attrs:{"active-color":"#13ce66","inactive-color":"#ff4949","active-text":"小写","inactive-text":"大写"},model:{value:t.lowerCase,callback:function(e){t.lowerCase=e},expression:"lowerCase"}}),t._v(" "),a("el-row",{staticClass:"line"},[a("el-col",{attrs:{span:2}},[a("el-button",{staticClass:"val-title",attrs:{plain:"",round:"",type:"primary"},on:{click:function(e){return t.copyValue(t.md5Value)}}},[t._v("MD5")])],1),t._v(" "),a("el-col",{attrs:{span:22}},[a("span",{staticClass:"val-class"},[t._v(t._s(t.md5Value))])])],1),t._v(" "),a("el-row",{staticClass:"line"},[a("el-col",{attrs:{span:2}},[a("el-button",{staticClass:"val-title",attrs:{type:"primary",plain:"",round:""},on:{click:function(e){return t.copyValue(t.sha1Value)}}},[t._v("SHA1")])],1),t._v(" "),a("el-col",{attrs:{span:22}},[a("span",{staticClass:"val-class"},[t._v(t._s(t.sha1Value))])])],1),t._v(" "),a("el-row",{staticClass:"line"},[a("el-col",{attrs:{span:2}},[a("el-button",{staticClass:"val-title",attrs:{type:"primary",plain:"",round:""},on:{click:function(e){return t.copyValue(t.sha256Value)}}},[t._v("SHA256")])],1),t._v(" "),a("el-col",{attrs:{span:22}},[a("span",{staticClass:"val-class"},[t._v(t._s(t.sha256Value))])])],1),t._v(" "),a("el-row",{staticClass:"line"},[a("el-col",{attrs:{span:2}},[a("el-button",{staticClass:"val-title",attrs:{type:"primary",plain:"",round:""},on:{click:function(e){return t.copyValue(t.sha512Value)}}},[t._v("SHA512")])],1),t._v(" "),a("el-col",{attrs:{span:22}},[a("span",{staticClass:"val-class"},[t._v(t._s(t.sha512Value))])])],1),t._v(" "),a("el-row",{staticClass:"line"},[a("el-col",{attrs:{span:3}},[a("el-button",{staticClass:"val-title",attrs:{type:"primary",plain:"",round:""},on:{click:function(e){return t.copyValue(t.base64Value)}}},[t._v("BASE64")]),t._v(" "),a("el-switch",{staticClass:"val-title",attrs:{"active-color":"#13ce66","inactive-color":"#ff4949","active-text":"加密","inactive-text":"解密"},model:{value:t.base64Encode,callback:function(e){t.base64Encode=e},expression:"base64Encode"}})],1),t._v(" "),a("el-col",{attrs:{span:21}},[a("span",{staticClass:"val-class val-base64"},[t._v(t._s(t.base64Value))])])],1)],1)},staticRenderFns:[]};var J=a("VU/8")(T,j,!1,function(t){a("JC7E")},"data-v-ba0c7484",null).exports,O={data:function(){return{text:""}},computed:{md5Value:function(){return 0===this.text.length?"":w()(this.text)},base64Value:function(){return 0===this.text.length?"":R.a.encode(this.text)}}},M={render:function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",[a("el-input",{attrs:{type:"textarea",rows:2,placeholder:"请输入明文"},model:{value:t.text,callback:function(e){t.text=e},expression:"text"}}),t._v(" "),a("el-row",[a("el-col",{staticClass:"item-row",attrs:{span:12}},[a("span",[t._v("MD5")]),t._v(" "),a("span",{staticClass:"val-class"},[t._v(t._s(t.md5Value))])]),t._v(" "),a("el-col",{staticClass:"item-row",attrs:{span:12}},[a("span",[t._v("SHA1")])])],1),t._v(" "),a("el-row",[a("el-col",{staticClass:"item-row",attrs:{span:24}},[a("span",[t._v("BASE64")]),t._v(" "),a("span",{staticClass:"val-class"},[t._v(t._s(t.base64Value))])])],1)],1)},staticRenderFns:[]};var L=a("VU/8")(O,M,!1,function(t){a("8L9t")},"data-v-559606c1",null).exports;n.default.use(s.a);var N=s.a.prototype.push;s.a.prototype.push=function(t){return N.call(this,t).catch(function(t){return t})};var Z=new s.a({routes:[{path:"/",name:"Home",redirect:"/Gadget",component:c,children:[{path:"/Cockpit",name:"Cockpit",component:E},{path:"/Gadget",name:"Gadget",component:S,redirect:"/Gadget/Codec",children:[{path:"/Gadget/Codec",name:"Codec",component:J},{path:"/Gadget/Json",name:"Json",component:L}]},{path:"/FileBrowser",name:"FileBrowser",component:x},{path:"/QuickCommand",name:"QuickCommand",component:V}]}]}),q=a("aLYK");a("tvR6");n.default.config.productionTip=!1,n.default.use(m.a),n.default.use(q.a,f.a),new n.default({el:"#app",router:Z,components:{App:o},template:"<App/>"})},PXCl:function(t,e,a){"use strict";(function(t){a.d(e,"a",function(){return G});const n="function"==typeof atob,r="function"==typeof btoa,o="function"==typeof t,s="function"==typeof TextDecoder?new TextDecoder:void 0,l="function"==typeof TextEncoder?new TextEncoder:void 0,i=Array.prototype.slice.call("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/="),c=(t=>{let e={};return i.forEach((t,a)=>e[t]=a),e})(),u=/^(?:[A-Za-z\d+\/]{4})*?(?:[A-Za-z\d+\/]{2}(?:==)?|[A-Za-z\d+\/]{3}=?)?$/,d=String.fromCharCode.bind(String),p="function"==typeof Uint8Array.from?Uint8Array.from.bind(Uint8Array):(t,e=(t=>t))=>new Uint8Array(Array.prototype.slice.call(t,0).map(e)),f=t=>t.replace(/=/g,"").replace(/[+\/]/g,t=>"+"==t?"-":"_"),h=t=>t.replace(/[^A-Za-z0-9\+\/]/g,""),m=t=>{let e,a,n,r,o="";const s=t.length%3;for(let s=0;s<t.length;){if((a=t.charCodeAt(s++))>255||(n=t.charCodeAt(s++))>255||(r=t.charCodeAt(s++))>255)throw new TypeError("invalid character found");o+=i[(e=a<<16|n<<8|r)>>18&63]+i[e>>12&63]+i[e>>6&63]+i[63&e]}return s?o.slice(0,s-3)+"===".substring(s):o},v=r?t=>btoa(t):o?e=>t.from(e,"binary").toString("base64"):m,b=o?e=>t.from(e).toString("base64"):t=>{let e=[];for(let a=0,n=t.length;a<n;a+=4096)e.push(d.apply(null,t.subarray(a,a+4096)));return v(e.join(""))},_=(t,e=!1)=>e?f(b(t)):b(t),g=t=>{if(t.length<2)return(e=t.charCodeAt(0))<128?t:e<2048?d(192|e>>>6)+d(128|63&e):d(224|e>>>12&15)+d(128|e>>>6&63)+d(128|63&e);var e=65536+1024*(t.charCodeAt(0)-55296)+(t.charCodeAt(1)-56320);return d(240|e>>>18&7)+d(128|e>>>12&63)+d(128|e>>>6&63)+d(128|63&e)},C=/[\uD800-\uDBFF][\uDC00-\uDFFFF]|[^\x00-\x7F]/g,x=t=>t.replace(C,g),y=o?e=>t.from(e,"utf8").toString("base64"):l?t=>b(l.encode(t)):t=>v(x(t)),w=(t,e=!1)=>e?f(y(t)):y(t),A=t=>w(t,!0),k=/[\xC0-\xDF][\x80-\xBF]|[\xE0-\xEF][\x80-\xBF]{2}|[\xF0-\xF7][\x80-\xBF]{3}/g,V=t=>{switch(t.length){case 4:var e=((7&t.charCodeAt(0))<<18|(63&t.charCodeAt(1))<<12|(63&t.charCodeAt(2))<<6|63&t.charCodeAt(3))-65536;return d(55296+(e>>>10))+d(56320+(1023&e));case 3:return d((15&t.charCodeAt(0))<<12|(63&t.charCodeAt(1))<<6|63&t.charCodeAt(2));default:return d((31&t.charCodeAt(0))<<6|63&t.charCodeAt(1))}},U=t=>t.replace(k,V),E=t=>{if(t=t.replace(/\s+/g,""),!u.test(t))throw new TypeError("malformed base64.");t+="==".slice(2-(3&t.length));let e,a,n,r="";for(let o=0;o<t.length;)e=c[t.charAt(o++)]<<18|c[t.charAt(o++)]<<12|(a=c[t.charAt(o++)])<<6|(n=c[t.charAt(o++)]),r+=64===a?d(e>>16&255):64===n?d(e>>16&255,e>>8&255):d(e>>16&255,e>>8&255,255&e);return r},F=n?t=>atob(h(t)):o?e=>t.from(e,"base64").toString("binary"):E,S=o?e=>p(t.from(e,"base64")):t=>p(F(t),t=>t.charCodeAt(0)),R=t=>S(P(t)),B=o?e=>t.from(e,"base64").toString("utf8"):s?t=>s.decode(S(t)):t=>U(F(t)),P=t=>h(t.replace(/[-_]/g,t=>"-"==t?"+":"/")),I=t=>B(P(t)),$=t=>({value:t,enumerable:!1,writable:!0,configurable:!0}),z=function(){const t=(t,e)=>Object.defineProperty(String.prototype,t,$(e));t("fromBase64",function(){return I(this)}),t("toBase64",function(t){return w(this,t)}),t("toBase64URI",function(){return w(this,!0)}),t("toBase64URL",function(){return w(this,!0)}),t("toUint8Array",function(){return R(this)})},D=function(){const t=(t,e)=>Object.defineProperty(Uint8Array.prototype,t,$(e));t("toBase64",function(t){return _(this,t)}),t("toBase64URI",function(){return _(this,!0)}),t("toBase64URL",function(){return _(this,!0)})},G={version:"3.7.2",VERSION:"3.7.2",atob:F,atobPolyfill:E,btoa:v,btoaPolyfill:m,fromBase64:I,toBase64:w,encode:w,encodeURI:A,encodeURL:A,utob:x,btou:U,decode:I,isValid:t=>{if("string"!=typeof t)return!1;const e=t.replace(/\s+/g,"").replace(/={0,2}$/,"");return!/[^\s0-9a-zA-Z\+/]/.test(e)||!/[^\s0-9a-zA-Z\-_]/.test(e)},fromUint8Array:_,toUint8Array:R,extendString:z,extendUint8Array:D,extendBuiltins:()=>{z(),D()}}}).call(e,a("EuP9").Buffer)},adnM:function(t,e){},"fPG/":function(t,e){},tvR6:function(t,e){}},["NHnr"]);
//# sourceMappingURL=app.5107a54596d4e39cb093.js.map