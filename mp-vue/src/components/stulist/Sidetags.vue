<template>
    <div>
        <el-row class="tac">
            <el-col>
                <h5>兴趣标签</h5>
                <el-menu
                default-active="2"
                class="el-menu-vertical-demo"
                @open="handleOpen"
                @close="handleClose">
                    <el-submenu index="1">
                        <template slot="title">
                        <i class="el-icon-location"></i>
                        <span>学校组织</span>
                        </template>
                        <el-menu-item index="1-1">学生会</el-menu-item>
                        <el-menu-item index="1-2">艺术团</el-menu-item>
                        <el-menu-item index="1-3">校团委</el-menu-item>
                        <el-submenu index="1-4">
                            <template slot="title">社团</template>
                            <el-menu-item index="1-4-1">话剧社</el-menu-item>
                        </el-submenu>
                    </el-submenu>
                    <el-menu-item index="2">
                        <i class="el-icon-menu"></i>
                        <span slot="title">科研项目</span>
                    </el-menu-item>
                    <el-menu-item index="3" disabled>
                        <i class="el-icon-document"></i>
                        <span slot="title">休闲娱乐</span>
                    </el-menu-item>
                    <el-menu-item index="4">
                        <i class="el-icon-setting"></i>
                        <span slot="title">就业工作</span>
                    </el-menu-item>
                </el-menu>
            </el-col>
        </el-row>
    </div>
</template>


<script>
  export default {
    name:'Sidetags',
    methods: {
      handleOpen(key, keyPath) {
        console.log(key, keyPath);
      },
      handleClose(key, keyPath) {
        console.log(key, keyPath);
      }
    }
  }
</script>