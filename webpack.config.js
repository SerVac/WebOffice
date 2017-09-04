var path = require('path'),
    webpack = require('webpack'),
    ExtractTextPlugin = require("extract-text-webpack-plugin");

var node_dir = __dirname + '/node_modules';
var img_dir = __dirname+'/src/main/resources/import/img';
var static_dir = './src/main/resources/static/';
// console.log("! PATH = "+__dirname);

module.exports = {
    entry: './src/main/js/app.js',
    devtool: 'sourcemaps',
    cache: true,
    output: {
        path: __dirname,
        filename: static_dir+'bundle.js'
    },
    module: {
        rules: [
            {
                test: /\.woff(2)?(\?v=[0-9]\.[0-9]\.[0-9])?$/,
                use: [
                    {
                        loader: 'url-loader?mimetype=application/font-woff',
                        options: {
                            outputPath: static_dir
                        }
                    }
                ]
            },
            {
                test: /\.(ttf|eot|svg)(\?v=[0-9]\.[0-9]\.[0-9])?$/,
                use: [
                    {
                        loader: 'file-loader',
                        options: {
                            outputPath: static_dir
                        }
                    }
                ]
            },
            {
                test: /\.(s(ass|css))$/,
                // loader: ExtractTextPlugin.extract('css-loader!sass-loader')
                use: ExtractTextPlugin.extract({
                    fallback: 'style-loader',
                    // use: ['css-loader', 'sass-loader']
                    use: [
                        {
                            loader: 'css-loader'
                        },
                        {
                            loader: 'postcss-loader',
                            options: {
                                plugins: function () { // post css plugins, can be exported to postcss.config.js
                                    return [
                                        require('precss'),
                                        require('autoprefixer')
                                    ];
                                }
                            }
                        },
                        {
                            loader: "sass-loader",
                            options: {
                                includePaths: [node_dir, img_dir]
                            }
                        }
                    ]
                })
            }
            , {
                test: /\.css$/,
                use: ExtractTextPlugin.extract({
                    fallback: 'style-loader',
                    use: ['css-loader']
                })
            },
            {
                test: /\.(?:gif|png|jpg|svg)$/,
                use: [
                    {
                        // loader: 'url-loader?name=./img/[hash].[ext]',
                        loader: 'url-loader',
                        options: {
                            outputPath: static_dir+'/img/'
                        }
                    }
                ]
            },
        ]

    },
    plugins: [
        new ExtractTextPlugin('./src/main/resources/static/css/style.css', {
                allChunks: true
        }),
        new webpack.ProvidePlugin({
            $: 'jquery',
            jQuery: 'jquery',
            'window.jQuery': 'jquery',
            Popper: ['popper.js', 'default'],
            Util: "exports-loader?Util!bootstrap/js/dist/util",
            Dropdown: "exports-loader?Dropdown!bootstrap/js/dist/dropdown"
        })
    ]
};