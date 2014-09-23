<style>
    .selected {
        background:red;
        color:white;
    }
</style>

<a href="public" ${title eq "Home" ? "class='selected'" : ""}>Home</a>
<a href="public?action=About" ${title eq "About us" ? "class='selected'" : ""}>About us</a>
<a href="public?action=Contact" ${title eq "Contact us" ? "class='selected'" : ""}>Contact us</a>