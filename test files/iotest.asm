
.CODE:

start:
    ptaw #0
    ptsr r0
    cmp r0, #1
    br(eq) =read
    br =start

read:
    ptr r1

    ptw r1
    br =start
