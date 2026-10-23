# 项目进度

更新日期：2026-10-23

## 已完成

- 确认项目目录起点为空，当前目录及上级路径没有适用的 AGENTS.md。
- 在 poker-lab 目录初始化独立 Git 仓库，主分支为 main。
- 编写项目愿景、分阶段路线、协作约定和基础忽略规则。
- 创建公开 GitHub 仓库 [qianwanwan/poker-lab](https://github.com/qianwanwan/poker-lab)，推送初始化提交，并设置 main 跟踪 origin/main。
- 开发者建立源码与测试目录，编写单模块 Maven 配置，使用 Java 21、JUnit 5.11.4、Compiler 3.13.0 和 Surefire 3.5.2。
- 审查 pom.xml 并复跑 mvn test，空工程构建成功。

## 当前状态

- Maven 工程配置已验收，没有 Java 源码、业务测试或可运行客户端；实际源码编译和 JUnit 测试执行尚未验证。
- 3D 方向暂定为 Blender 资源、Three.js 场景与 HTML/CSS 界面；尚未制作原型或验证性能。

## 下一步

1. 检查工程配置与文档差异，提交 Maven 工程配置。
2. 由开发者实现花色、点数与不可变的单张牌，测试取值、值相等和空值拒绝行为。

基础忽略规则检查已通过。已运行 mvn test，但当前没有测试用例，业务行为尚未验证。
