<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">
<head>
    <meta name="author" content="Benoit Schweblin">
    <meta name="viewport" content="user-scalable=no, width=device-width, initial-scale=1, maximum-scale=1">
    <meta name="mobile-web-app-capable" content="yes">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="referrer" content="always">
    <script type='text/javascript' src='https://csdnimg.cn/release/phoenix/write/tingyun-rum-559c80716d.js'></script>
    <title>写文章-CSDN博客</title>
    <link rel="icon" href="https://csdnimg.cn/public/favicon.ico" type="image/x-icon">
    <link rel="icon" sizes="192x192" href="https://csdnimg.cn/public/favicon.ico">
    <link href="https://csdnimg.cn/public/favicon.ico" rel="SHORTCUT ICON">
    <link rel="shortcut icon" sizes="192x192" href="https://csdnimg.cn/public/favicon.ico">
    <link rel="apple-touch-icon-precomposed" sizes="152x152" href="https://csdnimg.cn/public/favicon.ico">
    <link rel="stylesheet" href="https://static-blog.csdn.net/mdeditor/public/res-min/themes/header.css?20180420150436">
    <link rel="stylesheet" href="https://csdnimg.cn/release/phoenix/production/markdown_views-ea0013b516.css">
    <script type="text/javascript">
            var artId = 0;
            var get_article_address = "https://mp.csdn.net/mdeditor/getArticle";
            var set_article_address = "https://mp.csdn.net/mdeditor/saveArticle";
            var upload_image_address = "https://mp.csdn.net/UploadImage";
            window.isSwitch = true;
            window.baseDir = 'https://static-blog.csdn.net/mdeditor/public/res-min';
            var require = {
                baseUrl: window.baseDir
            };
    </script>
    <script src="https://static-blog.csdn.net/mdeditor/public/res/bower-libs/jquery/jquery.min.js?v6"></script>
    <script type="text/javascript" src="https://csdnimg.cn/rabbit/exposure-click/main-1.0.2.js"></script>
    <script type="text/javascript" src="https://csdnimg.cn/release/phoenix/write/switchHome-21de853c75.js"></script>
    <script src="https://static-blog.csdn.net/mdeditor/public/res/meditor.bundle.js?v6"></script>
    <script src="https://static-blog.csdn.net/mdeditor/public/res-min/csdn_label.js?v2017011201"></script>
    <script src="https://static-blog.csdn.net/mdeditor/public/res-min/require.js" data-main="https://static-blog.csdn.net/mdeditor/public/res-min/main_new.js?20180420143144"></script>
    <script type="text/javascript" src="https://csdnimg.cn/release/phoenix/write/first_guide-06c52b327b.js"></script>
</head>

<body style="overflow: hidden">
    <div class="loading"></div>
    <header>
        <div class="container">
            <div class="logo-box">
                <a class="header-logo" href="/" title="CSDN首页" target="_self">
                    <svg class="icon-logo">
                        <use xlink:href="#logo"></use>
                    </svg>
                    创作中心
                </a>
            </div>
            <div class="navbar-collapse-md">
                <a class="btn-bd-red" href="https://mp.csdn.net/postedit">
                    <svg class="icon icon-pencil">
                        <use xlink:href="#pencil"></use>
                    </svg>
                    写博客
                </a>
                <ul class="navbar-nav-md">
                    <li class="nav-item nav-avatar">
                        <a href="https://blog.csdn.net/qq_36771850" target="_blank">
                            <img class="nav-avatar-img" src="https://avatar.csdn.net/D/0/E/3_qq_36771850.jpg" width="56"
                                height="56">
                        </a>
                    </li>
                    <li class="nav-item header-ucenter  d-flex align-items-center flex-column">
                        <div class="top d-flex align-items-center">
                            <a href="https://blog.csdn.net/qq_36771850" class="header-ucenter-uname">qq_36771850</a>
                            <a class="header-ucenter-logout" href="https://passport.csdn.net/account/logout?ref=toolbar">退出</a>
                        </div>
                                                                    </li>
                </ul>
            </div>
        </div>
            </header>
    <main id="meditor_box">
        <div class="title-box clearfix d-flex">
            <input type="text" id="txtTitle" class="input-file-title" maxlength="100" placeholder="输入文章标题">
            <button class="bg-red btn-fabu">发布博客</button>
        </div>
        <div id="editorBox" style="position:relative;width:100%;height: 100%">
            <div id="csdnEditor"></div>
            <div class="fullOptBox">
                <div class="d-flex flex-row">
                    <button class="bg-red btn-fabu disabled-buttons" title="发布">
                        <i class="icon-chart-bar"></i>
                        <span class="txt">发布</span>
                    </button>
                    <button class="bg-red btn-baocun btn-blog-save disabled-buttons" title="保存">
                        <i class="icon-disk"></i>
                        <span class="txt">保存</span>
                    </button>
                    <a class="bg-gray btn-shanchu disabled-buttons" title="返回" href="/">
                        <i class="icon-fanhui"></i>
                        <span class="txt">返回</span>
                    </a>
                </div>
            </div>
        </div>
        <div class="moreDiv">
            <div class="pos-box">
                <div class="form-group row form-control-sm title">发布博客
                    <a class="btn-close">
                        <i class="icon-guanbi"></i>
                    </a>
                </div>
                <div class="form-group row form-control-sm">
                    <label class="labTitle col-form-label">文章标签：</label>
                    <div class="txt-box">
                        <div class="tag-box d-flex flex-row" id="tagBox">
                            <input name="hidTags" id="hidTags" value="" type="hidden">
                            <button class="btn-add-tag" id="addTag">
                                <i class="icon-tianjia mr8" aria-hidden="true"></i>添加标签</button>
                        </div>
                        <p class="mt8">
                            <span class="ipt-remark online-txt">最多添加5个标签</span>
                            <span class="ipt-remark unonline-txt">离线中，暂不可用</span>
                        </p>
                    </div>
                </div>
                <div class="form-group row form-control-sm">
                    <label class="labTitle col-form-label">个人分类：</label>
                    <div class="txt-box">
                        <div class="tag-box d-flex flex-row" id="categorieBox">
                            <input name="hidTags" id="hidCategories" value="" type="hidden">
                            <button class="btn-add-tag" id="addCategorie">
                                <i class="icon-tianjia mr8" aria-hidden="true"></i>添加新分类</button>
                        </div>
                        <p class="mt8">
                            <span class="ipt-remark online-txt"></span>
                            <span class="ipt-remark unonline-txt">离线中，暂不可用</span>
                        </p>
                                                <div class="categorie-list">
                                                        <div class="form-check">
                                <label class="form-check-label">
                                    <input class="form-check-input" type="checkbox" value="学习" id="6976773">
                                    <i class="lab-chk-icon" for="chk01">
                                        <svg xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" t="1514450759045" class="icon-checked"
                                            viewBox="0 0 1024 1024">
                                            <path d="M768 0H256C115.2 0 0 115.2 0 256v512c0 140.8 115.2 256 256 256h512c140.8 0 256-115.2 256-256V256c0-140.8-115.2-256-256-256z m17.6 377.6L460.8 728c-9.6 9.6-27.2 14.4-40 14.4-14.4 0-32-3.2-41.6-14.4l-142.4-153.6c-17.6-19.2-17.6-49.6 0-68.8 17.6-19.2 46.4-19.2 64 0l120 128 300.8-324.8c17.6-19.2 46.4-19.2 64 0s17.6 49.6 0 68.8z"
                                                p-id="2164" fill="#7ed321" data-spm-anchor-id="a313x.7781069.0.i4" class="" />
                                        </svg>
                                    </i>
                                    <span class="spanIsAgree">学习</span>
                                </label>
                            </div>
                                                        <div class="form-check">
                                <label class="form-check-label">
                                    <input class="form-check-input" type="checkbox" value="LintCode" id="7422544">
                                    <i class="lab-chk-icon" for="chk01">
                                        <svg xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" t="1514450759045" class="icon-checked"
                                            viewBox="0 0 1024 1024">
                                            <path d="M768 0H256C115.2 0 0 115.2 0 256v512c0 140.8 115.2 256 256 256h512c140.8 0 256-115.2 256-256V256c0-140.8-115.2-256-256-256z m17.6 377.6L460.8 728c-9.6 9.6-27.2 14.4-40 14.4-14.4 0-32-3.2-41.6-14.4l-142.4-153.6c-17.6-19.2-17.6-49.6 0-68.8 17.6-19.2 46.4-19.2 64 0l120 128 300.8-324.8c17.6-19.2 46.4-19.2 64 0s17.6 49.6 0 68.8z"
                                                p-id="2164" fill="#7ed321" data-spm-anchor-id="a313x.7781069.0.i4" class="" />
                                        </svg>
                                    </i>
                                    <span class="spanIsAgree">LintCode</span>
                                </label>
                            </div>
                                                        <div class="form-check">
                                <label class="form-check-label">
                                    <input class="form-check-input" type="checkbox" value="数字图像处理" id="7428425">
                                    <i class="lab-chk-icon" for="chk01">
                                        <svg xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" t="1514450759045" class="icon-checked"
                                            viewBox="0 0 1024 1024">
                                            <path d="M768 0H256C115.2 0 0 115.2 0 256v512c0 140.8 115.2 256 256 256h512c140.8 0 256-115.2 256-256V256c0-140.8-115.2-256-256-256z m17.6 377.6L460.8 728c-9.6 9.6-27.2 14.4-40 14.4-14.4 0-32-3.2-41.6-14.4l-142.4-153.6c-17.6-19.2-17.6-49.6 0-68.8 17.6-19.2 46.4-19.2 64 0l120 128 300.8-324.8c17.6-19.2 46.4-19.2 64 0s17.6 49.6 0 68.8z"
                                                p-id="2164" fill="#7ed321" data-spm-anchor-id="a313x.7781069.0.i4" class="" />
                                        </svg>
                                    </i>
                                    <span class="spanIsAgree">数字图像处理</span>
                                </label>
                            </div>
                                                        <div class="form-check">
                                <label class="form-check-label">
                                    <input class="form-check-input" type="checkbox" value="数据结构" id="7429301">
                                    <i class="lab-chk-icon" for="chk01">
                                        <svg xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" t="1514450759045" class="icon-checked"
                                            viewBox="0 0 1024 1024">
                                            <path d="M768 0H256C115.2 0 0 115.2 0 256v512c0 140.8 115.2 256 256 256h512c140.8 0 256-115.2 256-256V256c0-140.8-115.2-256-256-256z m17.6 377.6L460.8 728c-9.6 9.6-27.2 14.4-40 14.4-14.4 0-32-3.2-41.6-14.4l-142.4-153.6c-17.6-19.2-17.6-49.6 0-68.8 17.6-19.2 46.4-19.2 64 0l120 128 300.8-324.8c17.6-19.2 46.4-19.2 64 0s17.6 49.6 0 68.8z"
                                                p-id="2164" fill="#7ed321" data-spm-anchor-id="a313x.7781069.0.i4" class="" />
                                        </svg>
                                    </i>
                                    <span class="spanIsAgree">数据结构</span>
                                </label>
                            </div>
                                                        <div class="form-check">
                                <label class="form-check-label">
                                    <input class="form-check-input" type="checkbox" value="C语言" id="7429337">
                                    <i class="lab-chk-icon" for="chk01">
                                        <svg xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" t="1514450759045" class="icon-checked"
                                            viewBox="0 0 1024 1024">
                                            <path d="M768 0H256C115.2 0 0 115.2 0 256v512c0 140.8 115.2 256 256 256h512c140.8 0 256-115.2 256-256V256c0-140.8-115.2-256-256-256z m17.6 377.6L460.8 728c-9.6 9.6-27.2 14.4-40 14.4-14.4 0-32-3.2-41.6-14.4l-142.4-153.6c-17.6-19.2-17.6-49.6 0-68.8 17.6-19.2 46.4-19.2 64 0l120 128 300.8-324.8c17.6-19.2 46.4-19.2 64 0s17.6 49.6 0 68.8z"
                                                p-id="2164" fill="#7ed321" data-spm-anchor-id="a313x.7781069.0.i4" class="" />
                                        </svg>
                                    </i>
                                    <span class="spanIsAgree">C语言</span>
                                </label>
                            </div>
                                                        <div class="form-check">
                                <label class="form-check-label">
                                    <input class="form-check-input" type="checkbox" value="PAT" id="7460056">
                                    <i class="lab-chk-icon" for="chk01">
                                        <svg xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" t="1514450759045" class="icon-checked"
                                            viewBox="0 0 1024 1024">
                                            <path d="M768 0H256C115.2 0 0 115.2 0 256v512c0 140.8 115.2 256 256 256h512c140.8 0 256-115.2 256-256V256c0-140.8-115.2-256-256-256z m17.6 377.6L460.8 728c-9.6 9.6-27.2 14.4-40 14.4-14.4 0-32-3.2-41.6-14.4l-142.4-153.6c-17.6-19.2-17.6-49.6 0-68.8 17.6-19.2 46.4-19.2 64 0l120 128 300.8-324.8c17.6-19.2 46.4-19.2 64 0s17.6 49.6 0 68.8z"
                                                p-id="2164" fill="#7ed321" data-spm-anchor-id="a313x.7781069.0.i4" class="" />
                                        </svg>
                                    </i>
                                    <span class="spanIsAgree">PAT</span>
                                </label>
                            </div>
                                                        <div class="form-check">
                                <label class="form-check-label">
                                    <input class="form-check-input" type="checkbox" value="图像识别" id="7558339">
                                    <i class="lab-chk-icon" for="chk01">
                                        <svg xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" t="1514450759045" class="icon-checked"
                                            viewBox="0 0 1024 1024">
                                            <path d="M768 0H256C115.2 0 0 115.2 0 256v512c0 140.8 115.2 256 256 256h512c140.8 0 256-115.2 256-256V256c0-140.8-115.2-256-256-256z m17.6 377.6L460.8 728c-9.6 9.6-27.2 14.4-40 14.4-14.4 0-32-3.2-41.6-14.4l-142.4-153.6c-17.6-19.2-17.6-49.6 0-68.8 17.6-19.2 46.4-19.2 64 0l120 128 300.8-324.8c17.6-19.2 46.4-19.2 64 0s17.6 49.6 0 68.8z"
                                                p-id="2164" fill="#7ed321" data-spm-anchor-id="a313x.7781069.0.i4" class="" />
                                        </svg>
                                    </i>
                                    <span class="spanIsAgree">图像识别</span>
                                </label>
                            </div>
                                                        <div class="form-check">
                                <label class="form-check-label">
                                    <input class="form-check-input" type="checkbox" value="java" id="7596571">
                                    <i class="lab-chk-icon" for="chk01">
                                        <svg xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" t="1514450759045" class="icon-checked"
                                            viewBox="0 0 1024 1024">
                                            <path d="M768 0H256C115.2 0 0 115.2 0 256v512c0 140.8 115.2 256 256 256h512c140.8 0 256-115.2 256-256V256c0-140.8-115.2-256-256-256z m17.6 377.6L460.8 728c-9.6 9.6-27.2 14.4-40 14.4-14.4 0-32-3.2-41.6-14.4l-142.4-153.6c-17.6-19.2-17.6-49.6 0-68.8 17.6-19.2 46.4-19.2 64 0l120 128 300.8-324.8c17.6-19.2 46.4-19.2 64 0s17.6 49.6 0 68.8z"
                                                p-id="2164" fill="#7ed321" data-spm-anchor-id="a313x.7781069.0.i4" class="" />
                                        </svg>
                                    </i>
                                    <span class="spanIsAgree">java</span>
                                </label>
                            </div>
                                                    </div>
                                            </div>
                </div>
                <div class="form-group row form-control-sm">
                    <label class="labTitle col-form-label">文章类型：</label>
					<div class="txt-box">
						<select id="selType">
							<option value="0">请选择</option>
							<option value="original">原创</option>
							<option value="repost">转载</option>
							<option value="translated">翻译</option>
						</select>
						<span class="required">*</span>
					</div>
                    <label class="labTitle col-form-label ml-24">博客分类：</label>
                    <div class="txt-box">
                        <select class="droBlogType" id="radChl" name="radChl">
                            <option value="0">选择分类</option>
                            <option value="28">人工智能</option>
                            <option value="1">移动开发</option>
                            <option value="29">物联网</option>
                            <option value="15">架构</option>
                            <option value="2">云计算/大数据</option>
                            <option value="30">游戏开发</option>
                            <option value="12">运维</option>
                            <option value="6">数据库</option>
                            <option value="14">前端</option>
                            <option value="31">后端</option>
                            <option value="16">编程语言</option>
                            <option value="3">研发管理</option>
                            <option value="32">安全</option>
                            <option value="33">程序人生</option>
                            <option value="34">区块链</option>
                            <option value="35">音视频开发</option>
                            <option value="36">资讯</option>
                            <option value="37">计算机理论与基础</option>
                        </select>
						<span class="required">*</span>
                    </div>
                </div>
                <div class="form-group row form-control-sm">
                    <label class="labTitle col-form-label">私密文章：</label>
                    <div class="switch-box pt6">
                        <input name="public" value="private"  class="form-control form-control-sm chk-switch" id="chkIsHasNotify" type="checkbox">
                        <label for="chkIsHasNotify" class="lab-switch"></label>
                        <span class="ipt-remark chk-true online-txt">已设置成私密</span>
                        <span class="ipt-remark unonline-txt">离线中，暂不可用</span>
                    </div>
                </div>
                <div class="form-group opt-box row pull-right">
                    <input class="btn-smail btn-close" value="取消" title="取消" type="button">
                                        <input class="btn-smail btn-baocun btn-blog-save" value="保存为草稿" title="保存为草稿" type="button">
                    					<input class="btn-smail bg-red btn-publish btn-blog-save ml16" value="发表博客" title="发表博客" type="button">
                </div>
            </div>
        </div>
        <div class="mask"></div>
        <div class="alert-container" id="switchHtmlMode">
            <div class="pos-box">
                <a class="btn-close">
                    <i class="xheIcon icon-guanbi"></i>
                </a>
                <div class="title title-warning">提示</div>
                <div class="content">如果选择切换编辑器，您将丢失在此编写的文章内容！建议保存到草稿箱后再进行切换。 </div>
                <div class="opt-box text-right">
                    <a class="btn-smail c-blue" href="https://mp.csdn.net/postedit" target="_self">确认切换</a>
                    <button class="btn-smail c-red btn-cancel">放弃</button>
                </div>
            </div>
        </div>
        <div class="alert-container" id="createNewMode">
            <div class="pos-box">
                <a class="btn-close">
                    <i class="xheIcon icon-guanbi"></i>
                </a>
                <div class="title title-warning">提示</div>
                <div class="content">创建新的文章您将丢失当前编辑内容，可选择保存草稿存储当前编辑内容。</div>
                <div class="opt-box text-right">
                    <button class="btn-smail c-blue btn-caogao btn-blog-save">保存为草稿</button>
                    <button class="btn-smail c-red btn-new">写新文章</button>
                </div>
            </div>
        </div>
        <div class="alert-container finished-box" id="alertSuccess">
            <div class="pos-box">
                <div class="text-center title"></div>
                <div class="text-center status-box">
                    <i class="icon-success-font c-green"></i>发布成功
                </div>
                <p class="text-center zhaiyao">文章摘要由系统生成</p>
                <div class="opt-box text-center">
                    <button class="btn-outline-danger btn-new mr24">写新文章</button>
                    <a class="btn-outline-danger tolist mr24" href="https://mp.csdn.net/postlist">管理博文</a>
                    <a class="btn-outline-danger toarticle">查看文章</a>
                </div>
            </div>
        </div>
        <div class="notice-box">
            <i class="mr8 notice-icon icon-success"></i>
            <div class="pacman hide">
                <div></div>
                <div></div>
                <div></div>
                <div></div>
                <div></div>
            </div>
            <span class="notice">
                文章发布成功
            </span>
        </div>
    </main>
</body>

</html>