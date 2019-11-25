<template>
  <div>
    <div class="block"><el-avatar :size="90" :src="squareUrl"></el-avatar></div>
  </div>  
</template>
<script>
  export default {
    name:'Headimg',
    data () {  
      return {
        circleUrl: "https://cube.elemecdn.com/3/7c/3ea6beec64369c2642b92c6726f1epng.png",
        squareUrl: "https://cube.elemecdn.com/9/c2/f0ee8a3c7c9638a54940382568c9dpng.png",
        sizeList: ["large", "medium", "small"]
      }
    }
  }
</script>