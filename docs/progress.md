# 项目进度

更新日期：2026-10-23

## 已完成

- 建立独立 Git 仓库与公开 GitHub 仓库 [qianwanwan/poker-lab](https://github.com/qianwanwan/poker-lab)，配置 main 跟踪 origin/main。
- 编写项目愿景、协作约定和基础忽略规则。
- 建立 Java 21 单模块 Maven 工程，配置 JUnit 5.11.4，工程配置已提交（4907679）。
- 开发者完成 Suit、Rank 和 Card：四种花色、十三种点数、不可变表示、值相等与非空校验。
- 运行 mvn test，六个单张牌测试全部通过。

## 当前状态

- 单张牌功能已验收，源码和配套文档尚未提交；提交前可清理未使用的导入及已完成的 TODO 注释。
- 尚未实现牌堆、完整规则引擎或可运行客户端。
- 3D 方向暂定为 Blender 资源、Three.js 场景与 HTML/CSS 界面；尚未制作原型或验证性能。

## 下一步

1. 清理单张牌功能的教学占位内容，检查差异并提交。
2. 设计新牌堆的行为与验收案例，再由开发者实现完整且无重复的 52 张牌。

已验证：Tests run: 6, Failures: 0, Errors: 0, Skipped: 0，BUILD SUCCESS。牌堆及后续规则尚未验证。
