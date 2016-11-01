package com.ghx.app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private Button mBtn1;
    private Button mBtn2;
    private Button mBtn3;
    private Button mBtn4;
    private Button mBtn5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initAllView();

    }

    private void initAllView() {
        mBtn1 = (Button) findViewById(R.id.btn_1);
        mBtn2 = (Button) findViewById(R.id.btn_2);
        mBtn3 = (Button) findViewById(R.id.btn_3);
        mBtn4 = (Button) findViewById(R.id.btn_4);
        mBtn5 = (Button) findViewById(R.id.btn_5);

        mBtn1.setOnClickListener(this);
        mBtn2.setOnClickListener(this);
        mBtn3.setOnClickListener(this);
        mBtn4.setOnClickListener(this);
        mBtn5.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_1: {

                ExecutorService pool = Executors.newSingleThreadExecutor();

                for (int i = 0; i < 5; i++) {
                    pool.execute(new TestThread());
                }

                pool.shutdown();
            }
            break;
            case R.id.btn_2: {
                ExecutorService pool = Executors.newFixedThreadPool(3);

                for (int i = 0; i < 5; i++) {
                    pool.execute(new TestThread());
                }

                pool.shutdown();
            }
            break;
            case R.id.btn_3: {
                ExecutorService pool = Executors.newCachedThreadPool();

                for (int i = 0; i < 5; i++) {
                    pool.execute(new TestThread());
                }

                pool.shutdown();
            }
            break;
            case R.id.btn_4: {
                ExecutorService pool = Executors.newScheduledThreadPool(3);

                for (int i = 0; i < 5; i++) {
                    pool.execute(new TestThread());
                }

                pool.shutdown();
            }
            break;
            case R.id.btn_5: {

                /**
                 * Creates a thread pool that maintains enough threads to support
                 * the given parallelism level, and may use multiple queues to
                 * reduce contention. The parallelism level corresponds to the
                 * maximum number of threads actively engaged in, or available to
                 * engage in, task processing. The actual number of threads may
                 * grow and shrink dynamically. A work-stealing pool makes no
                 * guarantees about the order in which submitted tasks are
                 * executed.
                 */

                ExecutorService pool = Executors.newWorkStealingPool(3);

                for (int i = 0; i < 5; i++) {
                    pool.execute(new TestThread());
                }

                pool.shutdown();
            }
            break;
        }
    }
}
