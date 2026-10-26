# 项目进度

更新日期：2026-10-26

## 已完成

- 建立独立 Git 仓库与公开 GitHub 仓库 [qianwanwan/poker-lab](https://github.com/qianwanwan/poker-lab)，配置 main 跟踪 origin/main。
- 编写项目愿景、协作约定和基础忽略规则。
- 建立 Java 21 单模块 Maven 工程，配置 JUnit 5.11.4，工程配置已提交（4907679）。
- 开发者完成 Suit、Rank 和 Card：四种花色、十三种点数、不可变表示、值相等与非空校验。
- 运行 mvn test，六个单张牌测试全部通过。
- 单张牌功能已提交（dfa53e0）；开始本轮前工作区干净。
- 开发者完成标准 52 张牌堆、实际数量查询与只读快照，清理完成的 TODO、教学占位注释及未使用导入。
- 修正 Card 构造调用的参数顺序，运行 mvn clean test，全部八个测试通过。

## 当前状态

- 标准牌堆功能已通过当前验收，源码、注释清理和配套文档尚未提交。
- 尚无完整规则引擎或可运行客户端。
- 3D 方向暂定为 Blender 资源、Three.js 场景与 HTML/CSS 界面；尚未制作原型或验证性能。

## 下一步

1. 检查差异并提交标准牌堆功能及配套清理。
2. 设计抽牌行为与边界，之后再加入可复现的洗牌。

本轮验证：mvn clean test 重新编译源码和测试，Tests run: 8, Failures: 0, Errors: 0, Skipped: 0，BUILD SUCCESS。抽牌、洗牌及后续规则尚未实现或验证。
