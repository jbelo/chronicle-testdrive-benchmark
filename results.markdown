# HDD

## Settings

```
$ sudo hdparm /dev/sdb

/dev/sdb:
 multcount     = 16 (on)
 IO_support    =  1 (32-bit)
 readonly      =  0 (off)
 readahead     = 256 (on)
 geometry      = 121601/255/63, sectors = 1953525168, start = 0

$ sudo hdparm -i /dev/sdb

/dev/sdb:

 Model=ST1000LM014-1EJ164, FwRev=SM14, SerialNo=W380EGVK
 Config={ HardSect NotMFM HdSw>15uSec Fixed DTR>10Mbs RotSpdTol>.5% }
 RawCHS=16383/16/63, TrkSize=0, SectSize=0, ECCbytes=4
 BuffType=unknown, BuffSize=unknown, MaxMultSect=16, MultSect=16
 CurCHS=65535/1/63, CurSects=4128705, LBA=yes, LBAsects=1953525168
 IORDY=on/off, tPIO={min:120,w/IORDY:120}, tDMA={min:120,rec:120}
 PIO modes:  pio0 pio1 pio2 pio3 pio4
 DMA modes:  mdma0 mdma1 mdma2
 UDMA modes: udma0 udma1 udma2 udma3 udma4 udma5 *udma6
 AdvancedPM=yes: unknown setting WriteCache=enabled
 Drive conforms to: Reserved:  ATA/ATAPI-4,5,6,7

 * signifies the current active mode
```

## Runs

### HDD, synchronous, disk write cache disabled

```
# JMH 1.4.2 (released 80 days ago, please consider updating!)
# VM invoker: /opt/jdk1.8.0_25/jre/bin/java
# VM options: -Didea.launcher.port=7532 -Didea.launcher.bin.path=/opt/idea-IC-139.1117.1/bin -Dfile.encoding=UTF-8
# Warmup: 2 iterations, 1 s each
# Measurement: 5 iterations, 2 s each
# Timeout: 10 min per iteration
# Threads: 1 thread, will synchronize iterations
# Benchmark mode: Average time, time/op
# Benchmark: projects.MyBenchmark.testMethod

# Run progress: 0.00% complete, ETA 00:00:12
# Fork: 1 of 1
# Warmup Iteration   1: 45055.043 us/op
# Warmup Iteration   2: 53821.948 us/op
Iteration   1: 46660.348 us/op
Iteration   2: 54808.454 us/op
Iteration   3: 44098.829 us/op
Iteration   4: 53113.655 us/op
Iteration   5: 47768.664 us/op


Result: 49289.990 ±(99.9%) 17354.774 us/op [Average]
Statistics: (min, avg, max) = (44098.829, 49289.990, 54808.454), stdev = 4506.980
Confidence interval (99.9%): [31935.216, 66644.764]


# Run complete. Total time: 00:00:12

Benchmark                   Mode  Samples      Score       Error  Units
p.MyBenchmark.testMethod    avgt        5  49289.990 ± 17354.774  us/op
```


### HDD, asynchronous, disk write cache disabled

```
# JMH 1.4.2 (released 80 days ago, please consider updating!)
# VM invoker: /opt/jdk1.8.0_25/jre/bin/java
# VM options: -Didea.launcher.port=7534 -Didea.launcher.bin.path=/opt/idea-IC-139.1117.1/bin -Dfile.encoding=UTF-8
# Warmup: 2 iterations, 1 s each
# Measurement: 5 iterations, 2 s each
# Timeout: 10 min per iteration
# Threads: 1 thread, will synchronize iterations
# Benchmark mode: Average time, time/op
# Benchmark: projects.MyBenchmark.testMethod

# Run progress: 0.00% complete, ETA 00:00:12
# Fork: 1 of 1
# Warmup Iteration   1: 0.333 us/op
# Warmup Iteration   2: 0.248 us/op
Iteration   1: 0.237 us/op
Iteration   2: 0.232 us/op
Iteration   3: 0.204 us/op
Iteration   4: 0.210 us/op
Iteration   5: 0.208 us/op


Result: 0.218 ±(99.9%) 0.058 us/op [Average]
Statistics: (min, avg, max) = (0.204, 0.218, 0.237), stdev = 0.015
Confidence interval (99.9%): [0.160, 0.276]


# Run complete. Total time: 00:00:12

Benchmark                   Mode  Samples  Score   Error  Units
p.MyBenchmark.testMethod    avgt        5  0.218 ± 0.058  us/op
```


### HDD, synchronous, disk write cache enabled

```
# JMH 1.4.2 (released 80 days ago, please consider updating!)
# VM invoker: /opt/jdk1.8.0_25/jre/bin/java
# VM options: -Didea.launcher.port=7534 -Didea.launcher.bin.path=/opt/idea-IC-139.1117.1/bin -Dfile.encoding=UTF-8
# Warmup: 2 iterations, 1 s each
# Measurement: 5 iterations, 2 s each
# Timeout: 10 min per iteration
# Threads: 1 thread, will synchronize iterations
# Benchmark mode: Average time, time/op
# Benchmark: projects.MyBenchmark.testMethod

# Run progress: 0.00% complete, ETA 00:00:12
# Fork: 1 of 1
# Warmup Iteration   1: 5152.295 us/op
# Warmup Iteration   2: 5062.628 us/op
Iteration   1: 5272.685 us/op
Iteration   2: 5143.720 us/op
Iteration   3: 5049.775 us/op
Iteration   4: 5279.188 us/op
Iteration   5: 5034.466 us/op


Result: 5155.967 ±(99.9%) 451.510 us/op [Average]
Statistics: (min, avg, max) = (5034.466, 5155.967, 5279.188), stdev = 117.256
Confidence interval (99.9%): [4704.456, 5607.477]


# Run complete. Total time: 00:00:12

Benchmark                   Mode  Samples     Score     Error  Units
p.MyBenchmark.testMethod    avgt        5  5155.967 ± 451.510  us/op
```

### HDD, asynchronous, disk write cache enabled

```
# JMH 1.4.2 (released 80 days ago, please consider updating!)
# VM invoker: /opt/jdk1.8.0_25/jre/bin/java
# VM options: -Didea.launcher.port=7535 -Didea.launcher.bin.path=/opt/idea-IC-139.1117.1/bin -Dfile.encoding=UTF-8
# Warmup: 2 iterations, 1 s each
# Measurement: 5 iterations, 2 s each
# Timeout: 10 min per iteration
# Threads: 1 thread, will synchronize iterations
# Benchmark mode: Average time, time/op
# Benchmark: projects.MyBenchmark.testMethod

# Run progress: 0.00% complete, ETA 00:00:12
# Fork: 1 of 1
# Warmup Iteration   1: 0.346 us/op
# Warmup Iteration   2: 0.246 us/op
Iteration   1: 0.232 us/op
Iteration   2: 0.287 us/op
Iteration   3: 0.203 us/op
Iteration   4: 0.205 us/op
Iteration   5: 0.213 us/op


Result: 0.228 ±(99.9%) 0.134 us/op [Average]
Statistics: (min, avg, max) = (0.203, 0.228, 0.287), stdev = 0.035
Confidence interval (99.9%): [0.094, 0.362]


# Run complete. Total time: 00:00:12

Benchmark                   Mode  Samples  Score   Error  Units
p.MyBenchmark.testMethod    avgt        5  0.228 ± 0.134  us/op
```

# SSD

## Settings

```
$ sudo hdparm -i /dev/sda

/dev/sda:

 Model=SAMSUNG MZ7TD256HAFV-000L7, FwRev=DXT04L6Q, SerialNo=S16GNEAD411508
 Config={ Fixed }
 RawCHS=16383/16/63, TrkSize=0, SectSize=0, ECCbytes=0
 BuffType=unknown, BuffSize=unknown, MaxMultSect=1, MultSect=1
 CurCHS=65520/1/63, CurSects=4127760, LBA=yes, LBAsects=500118192
 IORDY=on/off, tPIO={min:120,w/IORDY:120}, tDMA={min:120,rec:120}
 PIO modes:  pio0 pio1 pio2 pio3 pio4
 DMA modes:  mdma0 mdma1 mdma2
 UDMA modes: udma0 udma1 udma2 udma3 udma4 udma5 *udma6
 AdvancedPM=no WriteCache=enabled
 Drive conforms to: unknown:  ATA/ATAPI-2,3,4,5,6,7

 * signifies the current active mode

$ sudo hdparm /dev/sda

/dev/sda:
 multcount     =  1 (on)
 IO_support    =  1 (32-bit)
 readonly      =  0 (off)
 readahead     = 256 (on)
 geometry      = 31130/255/63, sectors = 500118192, start = 0
```

## Measurements

### SSD, synchronous, disk write cache disabled

```
# JMH 1.4.2 (released 80 days ago, please consider updating!)
# VM invoker: /opt/jdk1.8.0_25/jre/bin/java
# VM options: -Didea.launcher.port=7534 -Didea.launcher.bin.path=/opt/idea-IC-139.1117.1/bin -Dfile.encoding=UTF-8
# Warmup: 2 iterations, 1 s each
# Measurement: 5 iterations, 2 s each
# Timeout: 10 min per iteration
# Threads: 1 thread, will synchronize iterations
# Benchmark mode: Average time, time/op
# Benchmark: projects.MyBenchmark.testMethod

# Run progress: 0.00% complete, ETA 00:00:12
# Fork: 1 of 1
# Warmup Iteration   1: 19063.630 us/op
# Warmup Iteration   2: 20350.479 us/op
Iteration   1: 18978.870 us/op
Iteration   2: 18537.810 us/op
Iteration   3: 18882.870 us/op
Iteration   4: 18413.092 us/op
Iteration   5: 19092.049 us/op


Result: 18780.938 ±(99.9%) 1123.931 us/op [Average]
Statistics: (min, avg, max) = (18413.092, 18780.938, 19092.049), stdev = 291.881
Confidence interval (99.9%): [17657.007, 19904.869]


# Run complete. Total time: 00:00:12

Benchmark                   Mode  Samples      Score      Error  Units
p.MyBenchmark.testMethod    avgt        5  18780.938 ± 1123.931  us/op
```


### SSD, asynchronous, disk write cache disabled

```
# JMH 1.4.2 (released 80 days ago, please consider updating!)
# VM invoker: /opt/jdk1.8.0_25/jre/bin/java
# VM options: -Didea.launcher.port=7536 -Didea.launcher.bin.path=/opt/idea-IC-139.1117.1/bin -Dfile.encoding=UTF-8
# Warmup: 2 iterations, 1 s each
# Measurement: 5 iterations, 2 s each
# Timeout: 10 min per iteration
# Threads: 1 thread, will synchronize iterations
# Benchmark mode: Average time, time/op
# Benchmark: projects.MyBenchmark.testMethod

# Run progress: 0.00% complete, ETA 00:00:12
# Fork: 1 of 1
# Warmup Iteration   1: 0.341 us/op
# Warmup Iteration   2: 0.249 us/op
Iteration   1: 0.234 us/op
Iteration   2: 0.236 us/op
Iteration   3: 0.219 us/op
Iteration   4: 0.201 us/op
Iteration   5: 0.213 us/op


Result: 0.221 ±(99.9%) 0.058 us/op [Average]
Statistics: (min, avg, max) = (0.201, 0.221, 0.236), stdev = 0.015
Confidence interval (99.9%): [0.163, 0.278]


# Run complete. Total time: 00:00:12

Benchmark                   Mode  Samples  Score   Error  Units
p.MyBenchmark.testMethod    avgt        5  0.221 ± 0.058  us/op
```


### SSD, synchronous, disk write cache enabled

```
# JMH 1.4.2 (released 80 days ago, please consider updating!)
# VM invoker: /opt/jdk1.8.0_25/jre/bin/java
# VM options: -Didea.launcher.port=7536 -Didea.launcher.bin.path=/opt/idea-IC-139.1117.1/bin -Dfile.encoding=UTF-8
# Warmup: 2 iterations, 1 s each
# Measurement: 5 iterations, 2 s each
# Timeout: 10 min per iteration
# Threads: 1 thread, will synchronize iterations
# Benchmark mode: Average time, time/op
# Benchmark: projects.MyBenchmark.testMethod

# Run progress: 0.00% complete, ETA 00:00:12
# Fork: 1 of 1
# Warmup Iteration   1: 14577.102 us/op
# Warmup Iteration   2: 16263.989 us/op
Iteration   1: 15624.308 us/op
Iteration   2: 15560.519 us/op
Iteration   3: 15551.038 us/op
Iteration   4: 15421.325 us/op
Iteration   5: 15505.520 us/op


Result: 15532.542 ±(99.9%) 289.729 us/op [Average]
Statistics: (min, avg, max) = (15421.325, 15532.542, 15624.308), stdev = 75.242
Confidence interval (99.9%): [15242.813, 15822.271]


# Run complete. Total time: 00:00:12

Benchmark                   Mode  Samples      Score     Error  Units
p.MyBenchmark.testMethod    avgt        5  15532.542 ± 289.729  us/op
```


### SSD, asynchronous, disk write cache enabled

```
# JMH 1.4.2 (released 80 days ago, please consider updating!)
# VM invoker: /opt/jdk1.8.0_25/jre/bin/java
# VM options: -Didea.launcher.port=7534 -Didea.launcher.bin.path=/opt/idea-IC-139.1117.1/bin -Dfile.encoding=UTF-8
# Warmup: 2 iterations, 1 s each
# Measurement: 5 iterations, 2 s each
# Timeout: 10 min per iteration
# Threads: 1 thread, will synchronize iterations
# Benchmark mode: Average time, time/op
# Benchmark: projects.MyBenchmark.testMethod

# Run progress: 0.00% complete, ETA 00:00:12
# Fork: 1 of 1
# Warmup Iteration   1: 0.325 us/op
# Warmup Iteration   2: 0.252 us/op
Iteration   1: 0.232 us/op
Iteration   2: 0.218 us/op
Iteration   3: 0.223 us/op
Iteration   4: 0.207 us/op
Iteration   5: 0.208 us/op


Result: 0.218 ±(99.9%) 0.040 us/op [Average]
Statistics: (min, avg, max) = (0.207, 0.218, 0.232), stdev = 0.010
Confidence interval (99.9%): [0.178, 0.258]


# Run complete. Total time: 00:00:12

Benchmark                   Mode  Samples  Score   Error  Units
p.MyBenchmark.testMethod    avgt        5  0.218 ± 0.040  us/op
```


# Summary

## HDD

| disk write cache | synch | asynch |
|------------------|-------|--------|
|enabled           |  5 ms | 0.2 us |
|disabled          | 49 ms | 0.2 us |

## SSD

| disk write cache | synch | asynch |
|------------------|-------|--------|
|enabled           | 15 ms | 0.2 us |
|disabled          | 19 ms | 0.2 us |

